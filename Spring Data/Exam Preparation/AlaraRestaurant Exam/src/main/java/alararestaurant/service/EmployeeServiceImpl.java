package alararestaurant.service;

import alararestaurant.domain.dtos.EmployeeSeedDto;
import alararestaurant.domain.entities.Employee;
import alararestaurant.domain.entities.Position;
import alararestaurant.repository.EmployeeRepository;
import alararestaurant.repository.PositionRepository;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static alararestaurant.constants.GlobalConstants.EMPLOYEES_FILE_PATH;
import static alararestaurant.constants.GlobalConstants.INVALID_DATA;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final FileUtil fileUtil;
    private final PositionRepository positionRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, FileUtil fileUtil, PositionRepository positionRepository) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.fileUtil = fileUtil;
        this.positionRepository = positionRepository;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesJsonFile() {
        String file = null;
        try {
            file = Files.readString(Path.of(EMPLOYEES_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    @Override
    public String importEmployees(String employees) {
        StringBuilder messages = new StringBuilder();
        EmployeeSeedDto[] employeesDtos = this.gson.fromJson(this.fileUtil.readFile(EMPLOYEES_FILE_PATH), EmployeeSeedDto[].class);
        Arrays.stream(employeesDtos).forEach(dto -> {
            if (!this.validationUtil.isValid(dto)) {
                messages.append(INVALID_DATA).append(System.lineSeparator());
                return;
            }
            if (this.employeeRepository.findByName(dto.getName()) != null) {
                messages.append("Data in DB").append(System.lineSeparator());
                return;
            }
            Employee employee = this.modelMapper.map(dto, Employee.class);
            Position position = this.positionRepository.findByName(dto.getPosition());
            if (position == null) {
                position = new Position();
                position.setName(dto.getPosition());
            }
            position.getEmployees().add(employee);
            employee.setPosition(position);
            this.positionRepository.saveAndFlush(position);
            this.employeeRepository.saveAndFlush(employee);
            messages.append(String.format("Record %s successfully imported.",employee.getName())).append(System.lineSeparator());
        });
        return messages.toString();
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return this.employeeRepository.findByName(name);
    }
}
