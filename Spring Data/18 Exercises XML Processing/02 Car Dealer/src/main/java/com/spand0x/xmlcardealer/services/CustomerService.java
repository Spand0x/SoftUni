package com.spand0x.xmlcardealer.services;

import com.spand0x.xmlcardealer.models.entities.Customer;

import javax.xml.bind.JAXBException;

public interface CustomerService {
    void seedCustomers() throws JAXBException;
    Customer getRandomCustomer();

    void getOrderedCustomers() throws JAXBException;
}
