package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.PictureSeedRootDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;


import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constants.GlobalConstants.PICTURE_PATH;


@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper, XmlParser xmlParser) {
        this.pictureRepository = pictureRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }


    @Override
    public String importPictures() throws IOException, JAXBException {
        StringBuilder messages = new StringBuilder();
        PictureSeedRootDto rootDto = this.xmlParser.importFromXml(PictureSeedRootDto.class, PICTURE_PATH);
        rootDto.getPictures().forEach(p->{
            if(this.validatorUtil.isValid(p)){
                if(this.pictureRepository.getByUrl(p.getUrl()) == null){
                    Picture picture = this.modelMapper.map(p, Picture.class);
                    this.pictureRepository.saveAndFlush(picture);
                    messages.append("Successfully imported picture - ").append(picture.getUrl());
                }else {
                    messages.append("Already in DB");
                }
            }else {
                messages.append("Invalid picture");
            }
            messages.append(System.lineSeparator());
        });


        return messages.toString();
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count()>0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {
        return Files.readString(Path.of(PICTURE_PATH));
    }

    @Override
    public Picture getPictureByUrl(String url) {
        return this.pictureRepository.getByUrl(url);
    }


}
