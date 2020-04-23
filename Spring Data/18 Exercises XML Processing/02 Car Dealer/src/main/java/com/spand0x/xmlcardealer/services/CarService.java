package com.spand0x.xmlcardealer.services;

import com.spand0x.xmlcardealer.models.entities.Car;

import javax.xml.bind.JAXBException;

public interface CarService {
    void seedCars() throws JAXBException;
    Car getRandomCar();
    void getCarsByMake(String make) throws JAXBException;

    void getCarsWithParts() throws JAXBException;
}
