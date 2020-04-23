package com.spand0x.xmlcardealer.services;

import com.spand0x.xmlcardealer.models.dtos.seed.PartsRootSeedDto;
import com.spand0x.xmlcardealer.models.entities.Part;
import com.spand0x.xmlcardealer.repositories.PartRepository;
import com.spand0x.xmlcardealer.utils.ValidationUtil;
import com.spand0x.xmlcardealer.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.xml.bind.JAXBException;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static com.spand0x.xmlcardealer.constants.GlobalConstants.*;

@Service
public class PartServiceImpl implements PartService {
    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final SupplierService supplierService;
    private final ValidationUtil validationUtil;

    public PartServiceImpl(PartRepository partRepository, ModelMapper modelMapper, XmlParser xmlParser, SupplierService supplierService, ValidationUtil validationUtil) {
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.supplierService = supplierService;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedParts() throws JAXBException {
        PartsRootSeedDto partsRootSeedDto = this.xmlParser.importFromXml(PartsRootSeedDto.class, PARTS_FILE_PATH);
        partsRootSeedDto.getParts().forEach(partDto->{
            if(this.validationUtil.isValid(partDto)){
                if(this.partRepository.findByNameAndPrice(partDto.getName(), partDto.getPrice()) == null){
                    Part part = this.modelMapper.map(partDto, Part.class);
                    part.setSupplier(this.supplierService.getRandomSupplier());
                    this.partRepository.saveAndFlush(part);
                }else {
                    System.out.println("Part already in the system");
                }
            }else {
                this.validationUtil.violations(partDto).stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            }
        });

    }

    @Override
    public List<Part> getRandomParts() {
        Random random = new Random();
        int randNum = random.nextInt(10)+10;
        List<Part> parts = new LinkedList<>();
        for (int i = 0; i < randNum; i++) {
            int randPartNum = random.nextInt((int) this.partRepository.count())+1;
            parts.add(this.partRepository.getOne((long) randPartNum));
        }
        return parts;
    }
}
