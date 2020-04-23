package com.spand0x.xmlparser.services;

import com.spand0x.xmlparser.models.entities.Category;

import javax.xml.bind.JAXBException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws JAXBException;

    Set<Category> getRandomCategories();

    void getCategoriesWithProducts() throws JAXBException;
}
