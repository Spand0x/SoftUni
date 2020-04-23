package com.spand0x.xmlcardealer.services;

import com.spand0x.xmlcardealer.models.dtos.queryOne.CustomerViewDto;
import com.spand0x.xmlcardealer.models.dtos.queryOne.CustomerViewRootDto;
import com.spand0x.xmlcardealer.models.dtos.seed.CustomersRootSeedDto;
import com.spand0x.xmlcardealer.models.entities.Customer;
import com.spand0x.xmlcardealer.repositories.CustomerRepository;
import com.spand0x.xmlcardealer.utils.ValidationUtil;
import com.spand0x.xmlcardealer.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.xml.bind.JAXBException;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.spand0x.xmlcardealer.constants.GlobalConstants.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedCustomers() throws JAXBException {
        CustomersRootSeedDto customersDto = this.xmlParser.importFromXml(CustomersRootSeedDto.class, CUSTOMERS_FILE_PATH);
        customersDto.getCustomers().forEach(dto->{
            if(this.validationUtil.isValid(dto)){
                if(this.customerRepository.getByName(dto.getName())==null){
                    Customer customer = this.modelMapper.map(dto, Customer.class);
                    this.customerRepository.save(customer);
                }else {
                    System.out.println("Customer already in Db");
                }
            }else {
                this.validationUtil.violations(dto)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            }
        });

    }

    @Override
    public Customer getRandomCustomer() {
        Random random = new Random();
        long randNum = random.nextInt((int) this.customerRepository.count())+1;
        return this.customerRepository.getOne(randNum);
    }

    @Override
    public void getOrderedCustomers() throws JAXBException {
        List<Customer> customers = this.customerRepository.getAllByIdIsNotNullOrderByBirthDateAscYoungDriverAsc();
        List<CustomerViewDto> customersDto = customers.stream().map(c -> this.modelMapper.map(c, CustomerViewDto.class))
                .collect(Collectors.toList());
        CustomerViewRootDto customersView = new CustomerViewRootDto();
        customersView.setCustomers(customersDto);
        this.xmlParser.exportToXml(customersView,QUERY_ONE_PATH);
    }
}
