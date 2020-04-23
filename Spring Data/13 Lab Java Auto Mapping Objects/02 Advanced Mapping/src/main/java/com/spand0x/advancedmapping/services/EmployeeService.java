package com.spand0x.advancedmapping.services;


import com.spand0x.advancedmapping.dtos.EmployeeDto;
import com.spand0x.advancedmapping.dtos.EmployeeSeedDto;

public interface EmployeeService {
    void save(EmployeeSeedDto employeeSeedDto);

    EmployeeDto findEmployeeByFirstName(String firstName);
}
