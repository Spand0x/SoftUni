package com.spand0x.xmlcardealer.services;

import javax.xml.bind.JAXBException;

public interface SaleService {
    void seedSales();

    void getSalesWithDiscount() throws JAXBException;
}
