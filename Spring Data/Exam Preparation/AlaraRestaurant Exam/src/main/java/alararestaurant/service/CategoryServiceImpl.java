package alararestaurant.service;

import alararestaurant.domain.entities.Category;
import alararestaurant.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String exportCategoriesByCountOfItems() {
        StringBuilder message = new StringBuilder();
        List<Category> categories = this.categoryRepository.findAllCategories();
        categories.forEach(c->{
            message.append("Category: ").append(c.getName()).append(System.lineSeparator());
            c.getItems().forEach(i->{
                message.append("---Item Name: ").append(i.getName()).append(System.lineSeparator());
                message.append("---Item Price: ").append(i.getPrice().toString()).append(System.lineSeparator());
                message.append(System.lineSeparator());
            });
        });
        return message.toString();
    }
}
