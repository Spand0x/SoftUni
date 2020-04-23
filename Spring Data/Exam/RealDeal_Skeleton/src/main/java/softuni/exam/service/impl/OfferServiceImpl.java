package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.OfferRootSeedDto;
import softuni.exam.models.entities.Car;
import softuni.exam.models.entities.Offer;
import softuni.exam.models.entities.Seller;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.OfferService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static softuni.exam.constants.GlobalConstants.*;

@Service
@Transactional
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final CarService carService;
    private final SellerService sellerService;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, CarService carService, SellerService sellerService) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.carService = carService;
        this.sellerService = sellerService;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFER_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder messages = new StringBuilder();
        OfferRootSeedDto offerRootDto = this.xmlParser.importFromXml(OfferRootSeedDto.class, OFFER_FILE_PATH);
        offerRootDto.getOffers().forEach(dto->{
            if(!this.validationUtil.isValid(dto)){
                messages.append(String.format(INVALID_MESSAGE, "offer")).append(System.lineSeparator());
                return;
            }
            if(this.offerRepository.findByDescriptionAndAddedOn(dto.getDescription(), dto.getAddedOn()) != null){
                messages.append(String.format(INVALID_MESSAGE, "offer")).append(System.lineSeparator());
                return;
            }
            Car car = this.carService.getCarById(dto.getCar().getId());
            if(car == null){
                messages.append(String.format(INVALID_MESSAGE, "offer")).append(System.lineSeparator());
                return;
            }
            Seller seller = sellerService.getSellerById(dto.getSeller().getId());
            if(seller == null){
                messages.append(String.format(INVALID_MESSAGE, "offer")).append(System.lineSeparator());
                return;
            }
            Offer offer = this.modelMapper.map(dto, Offer.class);
            car.getPictures().forEach(picture ->{
                offer.getPictures().add(picture);
            });
            offer.setCar(car);
            offer.setSeller(seller);
            this.offerRepository.saveAndFlush(offer);
            messages.append(String.format(SUCCESSFUL_MESSAGE,"offer",dto.getAddedOn()+ " - " + dto.isHasGoldStatus())).append(System.lineSeparator());

        });

        return messages.toString();
    }
}
