package alararestaurant.service;

import alararestaurant.domain.dtos.OrderSeedRootDto;
import alararestaurant.domain.entities.Employee;
import alararestaurant.domain.entities.Item;
import alararestaurant.domain.entities.Order;
import alararestaurant.domain.entities.OrderItem;
import alararestaurant.repository.OrderItemRepository;
import alararestaurant.repository.OrderRepository;
import alararestaurant.util.ValidationUtil;
import alararestaurant.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static alararestaurant.constants.GlobalConstants.INVALID_DATA;
import static alararestaurant.constants.GlobalConstants.ORDERS_FILE_PATH;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final EmployeeService employeeService;
    private final ItemService itemService;
    private final OrderItemRepository orderItemRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, EmployeeService employeeService, ItemService itemService, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.employeeService = employeeService;
        this.itemService = itemService;

        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public Boolean ordersAreImported() {
        return this.orderRepository.count() > 0;
    }

    @Override
    public String readOrdersXmlFile() {
        String file = null;
        try {
            file = Files.readString(Path.of(ORDERS_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    @Override
    @Transactional
    public String importOrders() {
        OrderSeedRootDto orderRootDto = null;
        try {
            orderRootDto = this.xmlParser.importFromXml(OrderSeedRootDto.class, ORDERS_FILE_PATH);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        StringBuilder messages = new StringBuilder();
        orderRootDto.getOrders()
                .stream()
                .forEach(dto->{
                    if(!this.validationUtil.isValid(dto)){
                        messages.append(INVALID_DATA).append(System.lineSeparator());
                        return;
                    }
                    if(this.employeeService.getEmployeeByName(dto.getEmployee()) == null){
                        messages.append(INVALID_DATA).append(System.lineSeparator());
                        return;
                    }
                    List<OrderItem> orderItems = new ArrayList<>();
                    Order order = this.modelMapper.map(dto, Order.class);
                    dto.getItems().getItems()
                            .stream()
                            .forEach(itemDto->{
                                if(!this.validationUtil.isValid(itemDto)){
                                    messages.append(INVALID_DATA).append(System.lineSeparator());
                                    return;
                                }
                                if(this.itemService.getItemByName(itemDto.getName()) == null){
                                    messages.append(INVALID_DATA).append(System.lineSeparator());
                                    return;
                                }
                                OrderItem orderItem = this.modelMapper.map(itemDto, OrderItem.class);
                                Item item = this.itemService.getItemByName(itemDto.getName());
                                orderItem.setItem(item);
                                orderItem.setOrder(order);
                                this.orderItemRepository.saveAndFlush(orderItem);
                                orderItems.add(orderItem);
                            });
                    order.setOrderItems(orderItems);
                    Employee employee = this.employeeService.getEmployeeByName(dto.getEmployee());
                    order.setEmployee(employee);
                    this.orderRepository.saveAndFlush(order);

                    messages.append(String.format("Order for %s on %s added",order.getCustomer(),order.getDateTime().toString()))
                            .append(System.lineSeparator());
                });
        return messages.toString();
    }

    @Override
    public String exportOrdersFinishedByTheBurgerFlippers() {
        StringBuilder message = new StringBuilder();
        String position = "Burger Flipper";
        List<Order> orders = this.orderRepository.getAllByPositionName(position);
        orders.forEach(o->{
            message.append("Name: ").append(o.getEmployee().getName()).append(System.lineSeparator());
            message.append("Orders: ").append(System.lineSeparator());
            message.append("\tCustomer: ").append(o.getCustomer()).append(System.lineSeparator());
            message.append("\tItems:").append(System.lineSeparator());
            o.getOrderItems().forEach(i->{
                message.append("\t\tName: ").append(i.getItem().getName()).append(System.lineSeparator());
                message.append("\t\tPrice: ").append(i.getItem().getPrice().toString()).append(System.lineSeparator());
                message.append("\t\tQuantity: ").append(i.getQuantity()).append(System.lineSeparator()).append(System.lineSeparator());
            });
        });
        return message.toString();
    }
}
