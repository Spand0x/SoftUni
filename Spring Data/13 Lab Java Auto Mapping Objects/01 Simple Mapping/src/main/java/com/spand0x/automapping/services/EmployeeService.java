package com.spand0x.automapping.services;


import com.spand0x.automapping.dtos.EmployeeDto;
import com.spand0x.automapping.dtos.EmployeeSeedDto;
import com.spand0x.automapping.entities.Employee;

public interface EmployeeService {
    void save(EmployeeSeedDto employeeSeedDto);

    EmployeeDto findEmployeeByFirstName(String firstName);
}
