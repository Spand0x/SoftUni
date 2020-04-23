package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.PictureSeedDto;
import softuni.exam.models.entities.Car;
import softuni.exam.models.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static softuni.exam.constants.GlobalConstants.*;

@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final CarService carService;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public PictureServiceImpl(PictureRepository pictureRepository, CarService carService, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.pictureRepository = pictureRepository;
        this.carService = carService;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files.readString(Path.of(PICTURE_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder messages = new StringBuilder();
        PictureSeedDto[] picturesDtos = this.gson.fromJson(Files.readString(Path.of(PICTURE_FILE_PATH)), PictureSeedDto[].class);
        Arrays.stream(picturesDtos).forEach(dto->{
            if(!this.validationUtil.isValid(dto)){
                messages.append(String.format(INVALID_MESSAGE, "Picture")).append(System.lineSeparator());
                return;
            }
            if(this.pictureRepository.findByName(dto.getName()) != null){
                messages.append(String.format(INVALID_MESSAGE, "Picture")).append(System.lineSeparator());
                return;
            }
            Car car = this.carService.getCarById(dto.getCar());
            if(car == null){
                messages.append(String.format(INVALID_MESSAGE, "Picture")).append(System.lineSeparator());
                return;
            }
            Picture picture = this.modelMapper.map(dto, Picture.class);
            picture.setCar(car);
            picture.setDateAndTime(LocalDateTime.parse(dto.getDateAndTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            this.pictureRepository.saveAndFlush(picture);
            messages.append(String.format(SUCCESSFUL_MESSAGE,"picture",dto.getName())).append(System.lineSeparator());
        });
        return messages.toString();
    }
}
