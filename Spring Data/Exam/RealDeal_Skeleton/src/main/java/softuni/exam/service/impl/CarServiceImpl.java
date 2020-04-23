package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.CarSeedDto;
import softuni.exam.models.entities.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static softuni.exam.constants.GlobalConstants.*;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;

    public CarServiceImpl(CarRepository carRepository, ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(Path.of(CAR_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException {
        CarSeedDto[] carsDto = this.gson.fromJson(Files.readString(Path.of(CAR_FILE_PATH)), CarSeedDto[].class);
        StringBuilder messages = new StringBuilder();
        Arrays.stream(carsDto).forEach(dto -> {
            if (!this.validationUtil.isValid(dto)) {
                messages.append(String.format(INVALID_MESSAGE, "car")).append(System.lineSeparator());
                return;
            }
            if (this.carRepository.findByMakeAndModelAndKilometers(dto.getMake(), dto.getModel(), dto.getKilometers()) != null) {
                messages.append(String.format(INVALID_MESSAGE, "Car")).append(System.lineSeparator());
                return;
            }
            Car car = this.modelMapper.map(dto, Car.class);
            car.setRegisteredOn(LocalDate.parse(dto.getRegisteredOn(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            this.carRepository.saveAndFlush(car);
            messages.append(String.format(SUCCESSFUL_MESSAGE,"car",car.getMake() + " - " + car.getModel())).append(System.lineSeparator());
        });
        return messages.toString();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        StringBuilder orderedCars = new StringBuilder();
//        "Car make - {make}, model - {model}
//	Kilometers - {kilometers}
//	Registered on - {registered on}
//	Number of pictures - {number of pictures}
        Set<Car> cars = this.carRepository.findAllOrderByPictureCount();
        cars.forEach(car->{
            orderedCars.append(String.format("Car make - %s, model - %s\n" +
                    "\tKilometers - %d\n" +
                    "\tRegistered on - %s\n" +
                    "\tNumber of pictures - %d\n",
                    car.getMake(),car.getModel(),
                    car.getKilometers(),
                    car.getRegisteredOn().toString(),
                    car.getPictures().size()));
        });
        return orderedCars.toString();
    }

    @Override
    public Car getCarById(long car) {
        return this.carRepository.getCarById(car);
    }
}
