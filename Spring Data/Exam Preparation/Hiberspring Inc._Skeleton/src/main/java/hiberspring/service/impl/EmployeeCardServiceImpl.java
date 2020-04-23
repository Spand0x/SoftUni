package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.common.GlobalConstants;
import hiberspring.domain.dtos.EmployeeCardSeedDto;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.service.EmployeeCardService;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static hiberspring.common.GlobalConstants.EMPLOYEE_CARDS_FILE_PATH;
import static hiberspring.common.GlobalConstants.INCORRECT_DATA_MESSAGE;

@Service
public class EmployeeCardServiceImpl implements EmployeeCardService {
    private final EmployeeCardRepository employeeCardRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public EmployeeCardServiceImpl(EmployeeCardRepository employeeCardRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.employeeCardRepository = employeeCardRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean employeeCardsAreImported() {
        return this.employeeCardRepository.count() > 0;
    }

    @Override
    public String readEmployeeCardsJsonFile() throws IOException {
        return Files.readString(Path.of(EMPLOYEE_CARDS_FILE_PATH));
    }

    @Override
    public String importEmployeeCards(String employeeCardsFileContent) throws FileNotFoundException {
        StringBuilder messages = new StringBuilder();
        EmployeeCardSeedDto[] employeeCardsDtos = this.gson.fromJson(employeeCardsFileContent, EmployeeCardSeedDto[].class);
        Arrays.stream(employeeCardsDtos).forEach(dto -> {
            if (!this.validationUtil.isValid(dto)) {
                messages.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                return;
            }
            if (this.employeeCardRepository.findByNumber(dto.getNumber()) != null) {
                messages.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                return;
            }
            EmployeeCard card = this.modelMapper.map(dto, EmployeeCard.class);
            this.employeeCardRepository.saveAndFlush(card);
            messages.append(String.format(GlobalConstants.SUCCESSFUL_IMPORT_MESSAGE, EmployeeCard.class.getSimpleName(), card.getNumber()))
                    .append(System.lineSeparator());
        });
        return messages.toString();
    }

    @Override
    public EmployeeCard getCardByNumber(String number) {
        return this.employeeCardRepository.findByNumber(number);
    }
}
