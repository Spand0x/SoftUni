package com.spand0x.xmlcardealer.services;

import com.spand0x.xmlcardealer.models.entities.Supplier;

import javax.xml.bind.JAXBException;

public interface SupplierService {
    void seedSuppliers() throws JAXBException;

    Supplier getRandomSupplier();

    void getLocalSuppliers() throws JAXBException;
}
