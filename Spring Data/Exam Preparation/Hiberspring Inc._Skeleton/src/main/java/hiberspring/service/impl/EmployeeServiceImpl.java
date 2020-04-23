package hiberspring.service.impl;

import hiberspring.common.GlobalConstants;
import hiberspring.domain.dtos.EmployeeRootSeedDto;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Employee;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.domain.entities.Town;
import hiberspring.repository.EmployeeRepository;
import hiberspring.service.BranchService;
import hiberspring.service.EmployeeService;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static hiberspring.common.GlobalConstants.EMPLOYEES_FILE_PATH;
import static hiberspring.common.GlobalConstants.INCORRECT_DATA_MESSAGE;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final EmployeeCardServiceImpl employeeCardService;
    private final BranchService branchService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, EmployeeCardServiceImpl employeeCardService, BranchService branchService) {
        this.employeeRepository = employeeRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.employeeCardService = employeeCardService;
        this.branchService = branchService;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        return Files.readString(Path.of(EMPLOYEES_FILE_PATH));
    }

    @Override
    public String importEmployees() throws JAXBException, FileNotFoundException {
        StringBuilder messages = new StringBuilder();
        EmployeeRootSeedDto employeeRootSeedDto = this.xmlParser.parseXml(EmployeeRootSeedDto.class, EMPLOYEES_FILE_PATH);
        employeeRootSeedDto.getEmployees().forEach(dto -> {
            if (!this.validationUtil.isValid(dto)) {
                messages.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                return;
            }
            if (this.employeeRepository.findByFirstNameAndLastNameAndPosition(dto.getFirstName(), dto.getLastName(), dto.getPosition()) != null) {
                messages.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                return;
            }
            Branch branch = this.branchService.getBranchByName(dto.getBranch());
            if (branch == null) {
                messages.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                return;
            }
            EmployeeCard employeeCard = this.employeeCardService.getCardByNumber(dto.getCard());
            if (employeeCard == null) {
                messages.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                return;
            }

            if (this.employeeRepository.findByEmployeeCard(employeeCard) != null) {
                messages.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                return;
            }

            Employee employee = this.modelMapper.map(dto, Employee.class);
            employee.setEmployeeCard(employeeCard);
            employee.setBranch(branch);
            this.employeeRepository.saveAndFlush(employee);
            messages.append(String.format(GlobalConstants.SUCCESSFUL_IMPORT_MESSAGE,
                    Employee.class.getSimpleName(), dto.getFirstName() + " " + dto.getLastName()))
                    .append(System.lineSeparator());

        });
        return messages.toString();
    }

    @Override
    public String exportProductiveEmployees() {
        List<Employee> allProductiveEmployees = this.employeeRepository.getAllProductiveEmployees();
        return allProductiveEmployees
                .stream()
                .map(e -> String.format("Name: %s\n" +
                "Position: %s\n" +
                "Card Number: %s\n",
                e.getFirstName() + " " + e.getLastName(),
                e.getPosition(),
                e.getEmployeeCard().getNumber()))
                .collect(Collectors.joining("-------------------------\n"));
    }
}
