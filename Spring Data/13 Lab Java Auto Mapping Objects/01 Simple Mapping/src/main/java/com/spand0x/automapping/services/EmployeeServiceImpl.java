package com.spand0x.automapping.services;

import com.spand0x.automapping.dtos.EmployeeDto;
import com.spand0x.automapping.dtos.EmployeeSeedDto;
import com.spand0x.automapping.entities.Employee;
import com.spand0x.automapping.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final ModelMapper modelMapper;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(ModelMapper modelMapper, EmployeeRepository employeeRepository) {
        this.modelMapper = modelMapper;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void save(EmployeeSeedDto employeeSeedDto) {
        Employee employee = modelMapper.map(employeeSeedDto,Employee.class);
        this.employeeRepository.saveAndFlush(employee);
        System.out.println();
    }

    @Override
    public EmployeeDto findEmployeeByFirstName(String firstName) {
        Employee employee = this.employeeRepository.findByFirstName(firstName);
        EmployeeDto employeeDto = this.modelMapper.map(employee,EmployeeDto.class);
        System.out.println();
        return employeeDto;
    }
}
