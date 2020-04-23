package com.spand0x.xmlcardealer.services;

import com.spand0x.xmlcardealer.models.entities.Part;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface PartService {
    void seedParts() throws JAXBException;
    List<Part> getRandomParts();
}
