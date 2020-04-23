package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.common.GlobalConstants;
import hiberspring.domain.dtos.TownSeedDto;
import hiberspring.domain.entities.Town;
import hiberspring.repository.TownRepository;
import hiberspring.service.TownService;
import hiberspring.util.FileIOUtil;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static hiberspring.common.GlobalConstants.INCORRECT_DATA_MESSAGE;
import static hiberspring.common.GlobalConstants.TOWNS_FILE_PATH;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final FileIOUtil fileIOUtil;

    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, FileIOUtil fileIOUtil) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.fileIOUtil = fileIOUtil;
    }

    @Override
    public Boolean townsAreImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsJsonFile() throws IOException {
        return Files.readString(Path.of(TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns(String townsFileContent) throws FileNotFoundException {
        StringBuilder messages = new StringBuilder();
        try {
            TownSeedDto[] townsDto = this.gson.fromJson(this.fileIOUtil.readFileContent(TOWNS_FILE_PATH), TownSeedDto[].class);
            Arrays.stream(townsDto).forEach(dto->{
                if(!this.validationUtil.isValid(dto)){
                    messages.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                    return;
                }
                if(this.townRepository.findByName(dto.getName()) != null){
                    messages.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                    return;
                }

                Town town = this.modelMapper.map(dto, Town.class);
                this.townRepository.saveAndFlush(town);

                messages.append(String.format(GlobalConstants.SUCCESSFUL_IMPORT_MESSAGE,Town.class.getSimpleName(),town.getName()))
                        .append(System.lineSeparator());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return messages.toString();
    }

    @Override
    public Town findTownByName(String name) {
        return this.townRepository.findByName(name);
    }
}
