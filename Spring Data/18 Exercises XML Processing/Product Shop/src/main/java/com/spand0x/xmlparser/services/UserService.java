package com.spand0x.xmlparser.services;


import com.spand0x.xmlparser.models.entities.User;

import javax.xml.bind.JAXBException;

public interface UserService {

    void seedUsers() throws JAXBException;

    User getRandomUser();

    void getUsersWithSoldProducts() throws JAXBException;

    void getUsersWithProducts() throws JAXBException;
}
