package com.spand0x.xmlcardealer.controller;

import com.spand0x.xmlcardealer.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;

@Component
public class AppController implements CommandLineRunner {
    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;

    public AppController(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.supplierService.seedSuppliers();
        this.partService.seedParts();
        this.carService.seedCars();
        this.customerService.seedCustomers();
        this.saleService.seedSales();
        orderedCustomersEx();
        carsFromMakeEx();
        localSuppliersEx();
        carsWithListOfPartsEx();
        salesWithDiscount();
    }

    private void salesWithDiscount() throws JAXBException {
        this.saleService.getSalesWithDiscount();
    }

    private void carsWithListOfPartsEx() throws JAXBException {
        this.carService.getCarsWithParts();
    }

    private void localSuppliersEx() throws JAXBException {
        this.supplierService.getLocalSuppliers();
    }

    private void carsFromMakeEx() throws JAXBException {
        String make = "Toyota";
        this.carService.getCarsByMake(make);
    }

    private void orderedCustomersEx() throws JAXBException {
        this.customerService.getOrderedCustomers();
    }
}
