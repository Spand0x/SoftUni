package hiberspring.service.impl;

import hiberspring.common.GlobalConstants;
import hiberspring.domain.dtos.ProductRootSeedDto;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Product;
import hiberspring.repository.ProductRepository;
import hiberspring.service.BranchService;
import hiberspring.service.ProductService;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static hiberspring.common.GlobalConstants.INCORRECT_DATA_MESSAGE;
import static hiberspring.common.GlobalConstants.PRODUCTS_FILE_PATH;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final BranchService branchService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil, BranchService branchService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.branchService = branchService;
    }

    @Override
    public Boolean productsAreImported() {
        return this.productRepository.count() > 0;
    }

    @Override
    public String readProductsXmlFile() throws IOException {
        return Files.readString(Path.of(PRODUCTS_FILE_PATH));
    }

    @Override
    public String importProducts() throws JAXBException, FileNotFoundException {
        StringBuilder messages = new StringBuilder();
        ProductRootSeedDto rootDto = this.xmlParser.parseXml(ProductRootSeedDto.class, PRODUCTS_FILE_PATH);
        rootDto.getProducts().forEach(dto->{
            if(!this.validationUtil.isValid(dto)){
                messages.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                return;
            }
            if(this.productRepository.findByName(dto.getName()) != null){
                messages.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                return;
            }
            Branch branch = this.branchService.getBranchByName(dto.getBranch());
            if(branch == null){
                messages.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                return;
            }

            Product product = this.modelMapper.map(dto, Product.class);
            product.setBranch(branch);
            this.productRepository.saveAndFlush(product);
            messages.append(String.format(GlobalConstants.SUCCESSFUL_IMPORT_MESSAGE,Product.class.getSimpleName(),product.getName()))
                    .append(System.lineSeparator());
        });
        return messages.toString();
    }
}
