package com.spand0x.xmlcardealer.services;

import com.spand0x.xmlcardealer.models.dtos.queryFour.CarPartListDto;
import com.spand0x.xmlcardealer.models.dtos.queryFour.CarPartListRootDto;
import com.spand0x.xmlcardealer.models.dtos.queryFour.PartListDto;
import com.spand0x.xmlcardealer.models.dtos.queryFour.PartListRootDto;
import com.spand0x.xmlcardealer.models.dtos.queryTwo.CarViewMakeDto;
import com.spand0x.xmlcardealer.models.dtos.queryTwo.CarViewMakeRootDto;
import com.spand0x.xmlcardealer.models.dtos.seed.CarsRootSeedDto;
import com.spand0x.xmlcardealer.models.entities.Car;
import com.spand0x.xmlcardealer.repositories.CarRepository;
import com.spand0x.xmlcardealer.utils.ValidationUtil;
import com.spand0x.xmlcardealer.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.xml.bind.JAXBException;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.spand0x.xmlcardealer.constants.GlobalConstants.*;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final PartService partService;
    private final ValidationUtil validationUtil;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, XmlParser xmlParser, PartService partService, ValidationUtil validationUtil) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.partService = partService;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedCars() throws JAXBException {
        CarsRootSeedDto carsDto = this.xmlParser.importFromXml(CarsRootSeedDto.class, CARS_FILE_PATH);
        carsDto.getCars().forEach(carDto -> {
            if (this.validationUtil.isValid(carDto)) {
                if (this.carRepository.getCarByMakeAndModelAndTravelledDistance(carDto.getMake()
                        , carDto.getModel()
                        , carDto.getTravelledDistance()) == null) {
                    Car car = this.modelMapper.map(carDto, Car.class);
                    car.setParts(this.partService.getRandomParts());
                    this.carRepository.saveAndFlush(car);
                } else {
                    System.out.println("Car already in Database");
                }
            } else {
                this.validationUtil.violations(carDto)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            }
        });
    }

    @Override
    public Car getRandomCar() {
        Random random = new Random();
        long randNum = random.nextInt((int) this.carRepository.count())+1;
        return this.carRepository.getOne(randNum);

    }

    @Override
    public void getCarsByMake(String make) throws JAXBException {
        List<Car> cars = this.carRepository.getAllByMakeOrderByModelAscTravelledDistanceDesc(make);
        List<CarViewMakeDto> carsDto = cars.stream().map(c -> this.modelMapper.map(c, CarViewMakeDto.class))
                .collect(Collectors.toList());
        CarViewMakeRootDto carDto = new CarViewMakeRootDto(carsDto);
        this.xmlParser.exportToXml(carDto,QUERY_TWO_PATH);
    }

    @Override
    @Transactional
    public void getCarsWithParts() throws JAXBException {
        List<Car> cars = this.carRepository.getAllByIdNotNull();
        List<CarPartListDto> carsDto = cars.stream()
                .map(c -> {
                    CarPartListDto carDto = this.modelMapper.map(c, CarPartListDto.class);
                    List<PartListDto> partsDto = c.getParts()
                            .stream()
                            .map(p -> this.modelMapper.map(p, PartListDto.class))
                            .collect(Collectors.toList());
                    PartListRootDto partRootDto = new PartListRootDto(partsDto);
                    carDto.setParts(partRootDto);
                    return carDto;
                })
                .collect(Collectors.toList());
        CarPartListRootDto carRoot = new CarPartListRootDto(carsDto);
        this.xmlParser.exportToXml(carRoot,QUERY_FOUR_PATH);

    }
}
