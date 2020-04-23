package com.spand0x.advancequering.services;


import com.spand0x.advancequering.entities.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Category getCategoryById(long id);

    Set<Category> getRandomCategories();
}
