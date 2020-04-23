package com.spand0x.advancedmapping.controller;

import com.spand0x.advancedmapping.dtos.EmployeeDto;
import com.spand0x.advancedmapping.dtos.EmployeeSeedDto;
import com.spand0x.advancedmapping.services.EmployeeService;
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
        EmployeeSeedDto employee1 =
                new EmployeeSeedDto("Gosho","Goshev",new BigDecimal("1000"),
                        LocalDate.of(2000,10,15),"Sofia",false,null);
        employeeService.save(employee1);

        //todo save and get

        EmployeeSeedDto employee2 =
                new EmployeeSeedDto("Pesho","Goshev",new BigDecimal("2000"),
                        LocalDate.of(2001,10,15),"Plovdiv",false,employee1);
        employeeService.save(employee2);

//        EmployeeSeedDto employee3 =
//                new EmployeeSeedDto("Maria","Goshev",new BigDecimal("3000"),
//                        LocalDate.of(2003,10,15),"Sofia",false,employee1);
//        employeeService.save(employee3);
//
//        EmployeeSeedDto employee4 =
//                new EmployeeSeedDto("Sasho","Goshev",new BigDecimal("4000"),
//                        LocalDate.of(2010,10,15),"Sofia",false,employee1);
//        employeeService.save(employee4);
//
//        EmployeeSeedDto employee5 =
//                new EmployeeSeedDto("Asq","Goshev",new BigDecimal("50"),
//                        LocalDate.of(1999,10,15),"Sofia",false,employee1);
//
//        employeeService.save(employee5);

        EmployeeDto employee = this.employeeService.findEmployeeByFirstName("Maria");
    }
}
