package com.spand0x.CompanyRooster;

import java.util.LinkedList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employeeList;

    public Department(String name) {
        this.name = name;
        employeeList = new LinkedList<>();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployee(Employee employee) {
        this.employeeList.add(employee);
    }

    public String getName() {
        return name;
    }

    public double getAverageSalary(){
        int count = 0;
        double salary = 0;
        for (Employee employee :
                employeeList) {
            salary += employee.getSalary();
            count++;
        }
        return salary/count;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }
}
