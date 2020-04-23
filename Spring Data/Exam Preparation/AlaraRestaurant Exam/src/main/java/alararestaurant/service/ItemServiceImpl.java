package alararestaurant.service;

import alararestaurant.domain.dtos.ItemSeedDto;
import alararestaurant.domain.entities.Category;
import alararestaurant.domain.entities.Item;
import alararestaurant.repository.CategoryRepository;
import alararestaurant.repository.ItemRepository;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static alararestaurant.constants.GlobalConstants.INVALID_DATA;
import static alararestaurant.constants.GlobalConstants.ITEMS_FILE_PATH;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;

    public ItemServiceImpl(ItemRepository itemRepository, CategoryRepository categoryRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, FileUtil fileUtil) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
    }

    @Override
    public Boolean itemsAreImported() {
        return this.itemRepository.count() > 0;
    }

    @Override
    public String readItemsJsonFile() {
        String file = null;
        try {
            file = Files.readString(Path.of(ITEMS_FILE_PATH));
        }catch (IOException e){
            e.printStackTrace();
        }
        return file;
    }

    @Override
    public String importItems(String items) {
        StringBuilder messages = new StringBuilder();
        ItemSeedDto[] itemsDtos = this.gson.fromJson(this.fileUtil.readFile(ITEMS_FILE_PATH), ItemSeedDto[].class);
        Arrays.stream(itemsDtos).forEach(dto->{
            if(!this.validationUtil.isValid(dto)){
                messages.append(INVALID_DATA).append(System.lineSeparator());
                return;
            }
            if(this.itemRepository.findByName(dto.getName()) != null){
                messages.append(INVALID_DATA).append(System.lineSeparator());
                return;
            }
            Category category = this.categoryRepository.findByName(dto.getCategory());
            if(category == null){
                category = new Category();
                category.setName(dto.getCategory());
            }
            Item item = this.modelMapper.map(dto, Item.class);
            category.getItems().add(item);
            this.categoryRepository.saveAndFlush(category);

            item.setCategory(category);
            this.itemRepository.saveAndFlush(item);
            messages.append(String.format("Record %s successfully imported.",dto.getName())).append(System.lineSeparator());
        });
        return messages.toString();
    }

    @Override
    public Item getItemByName(String name) {
        return this.itemRepository.findByName(name);
    }
}
