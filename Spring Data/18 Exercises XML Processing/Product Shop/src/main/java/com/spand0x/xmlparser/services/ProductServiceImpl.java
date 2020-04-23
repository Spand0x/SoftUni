package com.spand0x.xmlparser.services;


import com.spand0x.xmlparser.models.dtos.queryOne.ProductInRangeDto;
import com.spand0x.xmlparser.models.dtos.queryOne.ProductsInRangeDto;
import com.spand0x.xmlparser.models.dtos.seed.ProductsDto;
import com.spand0x.xmlparser.models.entities.Product;
import com.spand0x.xmlparser.repositories.ProductRepository;
import com.spand0x.xmlparser.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.spand0x.xmlparser.constants.GlobalConstants.*;
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, XmlParser xmlParser, UserService userService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    @Transactional
    public void seedProducts() throws JAXBException {
        ProductsDto productsDto = this.xmlParser.importFromXml(ProductsDto.class,PRODUCTS_FILE_PATH);
        List<Product> products = productsDto.getProductSeedDto().stream()
                .map(p->this.modelMapper.map(p,Product.class))
                .collect(Collectors.toList());
        Random random = new Random();
        for (Product product : products) {
            product.setSeller(this.userService.getRandomUser());
            int randomNum = random.nextInt(2);
            if(randomNum == 1){
                product.setBuyer(this.userService.getRandomUser());
            }
            product.setCategories(this.categoryService.getRandomCategories());
        }
        this.productRepository.saveAll(products);
    }

    @Override
    public void getProductsInRange(int priceMin, int priceMax) throws JAXBException {
        List<Product> products = this.productRepository.getAllByPriceBetweenOrderByPriceAsc(new BigDecimal(priceMin), new BigDecimal(priceMax));
        List<ProductInRangeDto> productsDto = products.stream()
                .map(p -> {
                    ProductInRangeDto prod = this.modelMapper.map(p, ProductInRangeDto.class);
                    String sellerFirst = p.getSeller().getFirstName();
                    if(sellerFirst == null){
                        sellerFirst = "";
                    }
                    String sellerLast = p.getSeller().getLastName();
                    if(sellerLast == null){
                        sellerLast = "";
                    }
                    String seller = sellerFirst + " " + sellerLast;
                    prod.setSeller(seller.trim());
                    return prod;
                })
                .collect(Collectors.toList());
        ProductsInRangeDto productsInRangeDto = new ProductsInRangeDto(productsDto);
        this.xmlParser.exportToXml(productsInRangeDto,QUERY_ONE_PATH);
    }
}
