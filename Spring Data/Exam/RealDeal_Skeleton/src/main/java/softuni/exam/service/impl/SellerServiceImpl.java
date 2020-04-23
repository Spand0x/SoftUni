package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.SellerRootSeedDto;
import softuni.exam.models.entities.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constants.GlobalConstants.*;

@Service
public class SellerServiceImpl implements SellerService {
    private final SellerRepository sellerRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    public SellerServiceImpl(SellerRepository sellerRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.sellerRepository = sellerRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(Path.of(SELLER_FILE_PATH));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        StringBuilder messages = new StringBuilder();
        SellerRootSeedDto sellerRootDto = this.xmlParser.importFromXml(SellerRootSeedDto.class, SELLER_FILE_PATH);
        sellerRootDto.getSellers()
                .stream()
                .forEach(dto->{
                    if (!this.validationUtil.isValid(dto)){
                        messages.append(String.format(INVALID_MESSAGE, "seller")).append(System.lineSeparator());
                        return;
                    }
                    if(this.sellerRepository.findByEmail(dto.getEmail()) != null){
                        messages.append(String.format(INVALID_MESSAGE, "seller")).append(System.lineSeparator());
                        return;
                    }
                    Seller seller = this.modelMapper.map(dto, Seller.class);
                    this.sellerRepository.saveAndFlush(seller);
                    messages.append(String.format(SUCCESSFUL_MESSAGE,"seller",seller.getLastName() + " - " + seller.getEmail())).append(System.lineSeparator());
                });
        return messages.toString();
    }

    @Override
    public Seller getSellerById(long id) {
        return this.sellerRepository.getSellerById(id);
    }
}
