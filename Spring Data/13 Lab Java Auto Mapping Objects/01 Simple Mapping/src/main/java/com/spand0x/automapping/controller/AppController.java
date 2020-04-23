package com.spand0x.automapping.controller;

import com.spand0x.automapping.dtos.EmployeeDto;
import com.spand0x.automapping.dtos.EmployeeSeedDto;
import com.spand0x.automapping.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
public class AppController implements CommandLineRunner {
    private final EmployeeService employeeService;

    public AppController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
//        EmployeeSeedDto employee1 =
//                new EmployeeSeedDto("Gosho","Goshev",new BigDecimal("1000"),LocalDate.of(2000,10,15),"Sofia");
//        EmployeeSeedDto employee2 =
//                new EmployeeSeedDto("Pesho","Goshev",new BigDecimal("2000"),LocalDate.of(2001,10,15),"Plovdiv");
//        EmployeeSeedDto employee3 =
//                new EmployeeSeedDto("Maria","Goshev",new BigDecimal("3000"),LocalDate.of(2003,10,15),"Sofia");
//        EmployeeSeedDto employee4 =
//                new EmployeeSeedDto("Sasho","Goshev",new BigDecimal("4000"),LocalDate.of(2010,10,15),"Sofia");
//        EmployeeSeedDto employee5 =
//                new EmployeeSeedDto("Asq","Goshev",new BigDecimal("50"),LocalDate.of(1999,10,15),"Sofia");
//
//        employeeService.save(employee1);
//        employeeService.save(employee2);
//        employeeService.save(employee3);
//        employeeService.save(employee4);
//        employeeService.save(employee5);

        EmployeeDto employee = this.employeeService.findEmployeeByFirstName("Maria");
    }
}
