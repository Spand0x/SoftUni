package com.spand0x.xmlparser.services;

import com.spand0x.xmlparser.models.dtos.queryThree.CategoriesStatisticDto;
import com.spand0x.xmlparser.models.dtos.queryThree.CategoryStatisticDto;
import com.spand0x.xmlparser.models.dtos.seed.CategoriesDto;
import com.spand0x.xmlparser.models.entities.Category;
import com.spand0x.xmlparser.repositories.CategoryRepository;
import com.spand0x.xmlparser.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static com.spand0x.xmlparser.constants.GlobalConstants.CATEGORIES_FILE_PATH;
import static com.spand0x.xmlparser.constants.GlobalConstants.QUERY_THREE_PATH;


@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, XmlParser xmlParser) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedCategories() throws JAXBException {
        CategoriesDto categoriesDto = this.xmlParser.importFromXml(CategoriesDto.class,CATEGORIES_FILE_PATH);
        List<Category> categories = categoriesDto.getCategories().stream()
                .map(c -> this.modelMapper.map(c, Category.class))
                .collect(Collectors.toList());
        this.categoryRepository.saveAll(categories);
    }

    @Override
    public Set<Category> getRandomCategories() {
        Random random = new Random();
        int randNumOfCat = random.nextInt((int) (this.categoryRepository.count() / 2))+1;
        Set<Category> categories = new HashSet<>();
        for (int i = 0; i < randNumOfCat; i++) {
            int randomNum = random.nextInt((int) this.categoryRepository.count()) + 1;
            Category category = this.categoryRepository.getOne((long) randomNum);
            categories.add(category);
        }
        return categories;
    }

    @Override
    public void getCategoriesWithProducts() throws JAXBException {
        List<String[]> categories = this.categoryRepository.getCategoriesStatistics();
        List<CategoryStatisticDto> categoriesDto = new LinkedList<>();
        for (String[] category : categories) {
            CategoryStatisticDto categoryDto = new CategoryStatisticDto();
            categoryDto.setName(category[0]);
            categoryDto.setProductCount(Integer.parseInt(category[1]));
            categoryDto.setAveragePrice(new BigDecimal(category[2]));
            categoryDto.setTotalPrice(new BigDecimal(category[3]));
            categoriesDto.add(categoryDto);
        }
        CategoriesStatisticDto categoriesStatisticDto = new CategoriesStatisticDto(categoriesDto);
        this.xmlParser.exportToXml(categoriesStatisticDto,QUERY_THREE_PATH);
    }
}
