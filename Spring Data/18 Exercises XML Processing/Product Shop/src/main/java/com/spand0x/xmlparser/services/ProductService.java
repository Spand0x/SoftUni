package com.spand0x.xmlparser.services;


import javax.xml.bind.JAXBException;

public interface ProductService {

    void seedProducts() throws JAXBException;

    void getProductsInRange(int priceMin, int priceMax) throws JAXBException;
}
