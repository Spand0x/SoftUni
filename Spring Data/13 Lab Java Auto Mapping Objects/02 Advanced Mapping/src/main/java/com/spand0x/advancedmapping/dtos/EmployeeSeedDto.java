package com.spand0x.advancedmapping.dtos;

import com.spand0x.advancedmapping.entities.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class EmployeeSeedDto {
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private LocalDate birthday;
    private String address;
    private boolean onHoliday;
    private EmployeeSeedDto manager;
    private Set<EmployeeSeedDto> employees;

    public EmployeeSeedDto(String firstName, String lastName, BigDecimal salary, LocalDate birthday, String address, boolean onHoliday, EmployeeSeedDto manager) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birthday = birthday;
        this.address = address;
        this.onHoliday = onHoliday;
        this.manager = manager;
        this.employees = new HashSet<>();
    }

    public boolean isOnHoliday() {
        return onHoliday;
    }

    public void setOnHoliday(boolean onHoliday) {
        this.onHoliday = onHoliday;
    }

    public EmployeeSeedDto getManager() {
        return manager;
    }

    public void setManager(EmployeeSeedDto manager) {
        this.manager = manager;
    }

    public Set<EmployeeSeedDto> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeSeedDto> employees) {
        this.employees = employees;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
