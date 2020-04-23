package com.spand0x.springbookshopsystem.services;


import com.spand0x.springbookshopsystem.entities.Category;

import java.io.IOException;

public interface CategoryService {
    void seedCategories() throws IOException;

    Category getCategoryById(long id);
}
