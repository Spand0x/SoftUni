package com.spand0x.advancequering.services.impl;


import com.spand0x.advancequering.entities.Category;
import com.spand0x.advancequering.repositories.CategoryRepository;
import com.spand0x.advancequering.services.CategoryService;
import com.spand0x.advancequering.utils.FileUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static com.spand0x.advancequering.constants.GlobalConstants.CATEGORIES_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedCategories() throws IOException {
        //todo: implement in method: video-1:20
        if (this.categoryRepository.count() != 0) {
            return;
        }
        String[] fileContent = this.fileUtil.readFileContent(CATEGORIES_FILE_PATH);
        Arrays.stream(fileContent).forEach(r -> {
            Category category = new Category(r);
            this.categoryRepository.saveAndFlush(category);
        });
    }



    @Override
    public Set<Category> getRandomCategories() {
        Random random = new Random();
        int bound = random.nextInt(3) + 1;
        Set<Category> result = new HashSet<>();
        for (int i = 1; i <= bound; i++) {
            int randomId = random.nextInt(8) + 1;
            result.add(this.getCategoryById(randomId));
        }
        return result;
    }

    @Override
    public Category getCategoryById(long id) {
        return this.categoryRepository.getOne(id);
    }


}
