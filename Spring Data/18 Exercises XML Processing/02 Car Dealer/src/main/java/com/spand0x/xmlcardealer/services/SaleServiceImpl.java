package com.spand0x.xmlcardealer.services;

import com.spand0x.xmlcardealer.models.dtos.queryFive.SaleDiscountDto;
import com.spand0x.xmlcardealer.models.dtos.queryFive.SaleDiscountRootDto;
import com.spand0x.xmlcardealer.models.entities.Part;
import com.spand0x.xmlcardealer.models.entities.Sale;
import com.spand0x.xmlcardealer.repositories.SaleRepository;
import com.spand0x.xmlcardealer.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.spand0x.xmlcardealer.constants.GlobalConstants.QUERY_FIVE_PATH;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final CarService carService;
    private final CustomerService customerService;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public SaleServiceImpl(SaleRepository saleRepository, CarService carService, CustomerService customerService, ModelMapper modelMapper, XmlParser xmlParser) {
        this.saleRepository = saleRepository;
        this.carService = carService;
        this.customerService = customerService;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedSales() {

        for (int i = 0; i < 20; i++) {
            Sale sale = new Sale();
            sale.setDiscount(this.getRandomDiscount());
            sale.setCar(this.carService.getRandomCar());
            sale.setCustomer(this.customerService.getRandomCustomer());
            this.saleRepository.saveAndFlush(sale);
        }
    }

    @Override
    public void getSalesWithDiscount() throws JAXBException {
        List<Sale> sales = this.saleRepository.findAll();
        List<SaleDiscountDto> salesDto = sales.stream()
                .map(s -> {
                    SaleDiscountDto saleDto = this.modelMapper.map(s, SaleDiscountDto.class);
                    saleDto.setPrice(s.getCar().getParts()
                            .stream()
                            .map(Part::getPrice)
                            .reduce(BigDecimal.ZERO,BigDecimal::add));
                    saleDto.setPriceWithDiscount(saleDto.getPrice()
                            .multiply(BigDecimal.valueOf(1.0d - saleDto.getDiscount())));
                    return saleDto;
                }).collect(Collectors.toList());
        SaleDiscountRootDto rootDto = new SaleDiscountRootDto(salesDto);
        this.xmlParser.exportToXml(rootDto,QUERY_FIVE_PATH);
    }

    private double getRandomDiscount() {
        double[] discounts = {0,0.05,0.1,0.15,0.2,0.3,0.4,0.5};
        Random random = new Random();
        int randNum = random.nextInt(discounts.length);
        return discounts[randNum];
    }
}
