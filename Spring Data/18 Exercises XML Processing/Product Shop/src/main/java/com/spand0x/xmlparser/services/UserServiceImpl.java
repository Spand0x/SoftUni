package com.spand0x.xmlparser.services;


import com.spand0x.xmlparser.models.dtos.queryFour.ProductsRootDto;
import com.spand0x.xmlparser.models.dtos.queryFour.SoldProductDto;
import com.spand0x.xmlparser.models.dtos.queryFour.UserProductsSoldDto;
import com.spand0x.xmlparser.models.dtos.queryFour.UsersRootDto;
import com.spand0x.xmlparser.models.dtos.queryTwo.ProductSoldDto;
import com.spand0x.xmlparser.models.dtos.queryTwo.ProductsSoldDto;
import com.spand0x.xmlparser.models.dtos.queryTwo.UserProductsDto;
import com.spand0x.xmlparser.models.dtos.queryTwo.UsersProductsDto;
import com.spand0x.xmlparser.models.dtos.seed.UserSeedDto;
import com.spand0x.xmlparser.models.dtos.seed.UsersDto;
import com.spand0x.xmlparser.models.entities.User;
import com.spand0x.xmlparser.repositories.UserRepository;
import com.spand0x.xmlparser.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import static com.spand0x.xmlparser.constants.GlobalConstants.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, XmlParser xmlParser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedUsers() throws JAXBException {
        UsersDto usersDto = this.xmlParser.importFromXml(UsersDto.class,USERS_FILE_PATH);
        List<User> users = usersDto.getUserSeedDtos().stream()
                .map(u -> this.modelMapper.map(u, User.class))
                .collect(Collectors.toList());

        this.userRepository.saveAll(users);
    }

    @Override
    public User getRandomUser() {
        Random random = new Random();
        int randomNum = random.nextInt((int) this.userRepository.count())+1;

        return this.userRepository.getOne((long) randomNum);
    }

    @Override
    public void getUsersWithSoldProducts() throws JAXBException {
        Set<User> users = this.userRepository.getAllByBoughtIsNotNullOrderByLastNameAscFirstNameAsc();
        List<UserProductsDto> usersDto = users.stream()
                .map(u -> {
                    List<ProductSoldDto> products = u.getSold().stream()
                            .map(p -> this.modelMapper.map(p, ProductSoldDto.class))
                            .collect(Collectors.toList());
                    UserProductsDto updDto = this.modelMapper.map(u, UserProductsDto.class);
                    ProductsSoldDto productsSoldDto = new ProductsSoldDto();
                    productsSoldDto.setProducts(products);
                    updDto.setSoldProducts(productsSoldDto);
                    return updDto;
                }).collect(Collectors.toList());
        UsersProductsDto usersProductsDto = new UsersProductsDto(usersDto);
        this.xmlParser.exportToXml(usersProductsDto,QUERY_TWO_PATH);
    }

    @Override
    public void getUsersWithProducts() throws JAXBException {
        List<User> users = this.userRepository.getUsersWithAtLeastOneSellingProduct();
        List<UserProductsSoldDto> usersDto = users.stream()
                .map(u -> {
                    List<SoldProductDto> products = u.getSold().stream()
                            .map(p -> this.modelMapper.map(p, SoldProductDto.class))
                            .collect(Collectors.toList());
                    UserProductsSoldDto upsdDto = this.modelMapper.map(u, UserProductsSoldDto.class);
                    ProductsRootDto productsRootDto = new ProductsRootDto(products);
                    productsRootDto.setCount(products.size());
                    upsdDto.setSoldProducts(productsRootDto);
                    return upsdDto;
                }).collect(Collectors.toList());
        UsersRootDto usersRootDto = new UsersRootDto();
        usersRootDto.setCount(usersDto.size());
        usersRootDto.setUsers(usersDto);
        this.xmlParser.exportToXml(usersRootDto,QUERY_FOUR_PATH);
    }
}
