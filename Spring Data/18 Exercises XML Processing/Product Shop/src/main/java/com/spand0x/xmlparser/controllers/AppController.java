package com.spand0x.xmlparser.controllers;

import com.spand0x.xmlparser.services.CategoryService;
import com.spand0x.xmlparser.services.ProductService;
import com.spand0x.xmlparser.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.util.Scanner;

@Component
public class AppController implements CommandLineRunner {
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final Scanner scanner;

    public AppController(UserService userService, CategoryService categoryService, ProductService productService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
//        this.userService.seedUsers();
//        this.categoryService.seedCategories();
//        this.productService.seedProducts();
//        getAllProductsInRangeEx();
//        successfullySoldProductsEx();
//        categoriesByProductsCount();
        usersAndProducts();
    }

    private void usersAndProducts() throws JAXBException {
        this.userService.getUsersWithProducts();
    }

    private void categoriesByProductsCount() throws JAXBException {
        this.categoryService.getCategoriesWithProducts();
    }

    private void successfullySoldProductsEx() throws JAXBException {
        this.userService.getUsersWithSoldProducts();
    }

    private void getAllProductsInRangeEx() throws JAXBException {
        System.out.println("Query 1: Products in range" + System.lineSeparator() + "Please enter min range:");
        int priceMin = Integer.parseInt(this.scanner.nextLine());
        System.out.println("Please enter max range:");
        int priceMax = Integer.parseInt(this.scanner.nextLine());
        this.productService.getProductsInRange(priceMin,priceMax);
    }

}
