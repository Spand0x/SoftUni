package com.spand0x.xmlcardealer.services;

import com.spand0x.xmlcardealer.models.dtos.queryThree.SupplierLocalDto;
import com.spand0x.xmlcardealer.models.dtos.queryThree.SupplierLocalRootDto;
import com.spand0x.xmlcardealer.models.dtos.seed.SuppliersRootSeedDto;
import com.spand0x.xmlcardealer.models.entities.Supplier;
import com.spand0x.xmlcardealer.repositories.SupplierRepository;
import com.spand0x.xmlcardealer.utils.ValidationUtil;
import com.spand0x.xmlcardealer.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.xml.bind.JAXBException;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.spand0x.xmlcardealer.constants.GlobalConstants.*;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedSuppliers() throws JAXBException {
        SuppliersRootSeedDto suppliersRootSeedDto = this.xmlParser.importFromXml(SuppliersRootSeedDto.class, SUPPLIERS_FILE_PATH);
        suppliersRootSeedDto.getSuppliers().forEach(dto->{
            if(this.validationUtil.isValid(dto)){
                if(this.supplierRepository.findByName(dto.getName()) == null){
                    Supplier supplier = this.modelMapper.map(dto,Supplier.class);
                    this.supplierRepository.saveAndFlush(supplier);
                }else{
                    System.out.println("Supplier already exists");
                }
            }else {
                this.validationUtil.violations(dto).stream()
                .map(ConstraintViolation::getMessage)
                .forEach(System.out::println);
            }
        });

    }

    @Override
    public Supplier getRandomSupplier() {
        Random random = new Random();
        int randNum = random.nextInt((int) this.supplierRepository.count())+1;
        return this.supplierRepository.getOne((long) randNum);
    }

    @Override
    public void getLocalSuppliers() throws JAXBException {
        Set<Supplier> suppliers = this.supplierRepository.getAllByImporterFalse();
        List<SupplierLocalDto> suppliersDto = suppliers
                .stream()
                .map(s -> {
                    SupplierLocalDto dto = this.modelMapper.map(s, SupplierLocalDto.class);
                    dto.setPartsCount(s.getParts().size());
                    return dto;
                })
                .collect(Collectors.toList());
        SupplierLocalRootDto rootDto = new SupplierLocalRootDto(suppliersDto);
        this.xmlParser.exportToXml(rootDto,QUERY_THREE_PATH);
    }
}
