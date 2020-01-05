package com.spand0x.CompanyRooster;

import java.awt.print.Pageable;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Department> departments = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Employee currentEmployee = createEmployee(input);
            if (input.length == 5) {
                if (input[4].contains("@")) {
                    String email = input[4];
                    currentEmployee.setEmail(email);
                } else {
                    int age = Integer.parseInt(input[4]);
                    currentEmployee.setAge(age);
                }
            } else if (input.length == 6) {
                String email;
                int age;
                if (input[4].contains("@")) {
                    email = input[4];
                    age = Integer.parseInt(input[5]);
                } else {
                    age = Integer.parseInt(input[4]);
                    email = input[5];
                }
                currentEmployee.setEmail(email);
                currentEmployee.setAge(age);
            }
            String departmentName = currentEmployee.getDepartment();
            if (!departments.containsKey(departmentName)) {
                departments.put(departmentName, new Department(departmentName));
            }
            departments.get(departmentName).setEmployee(currentEmployee);
        }
        String bestDepartment = departments.entrySet().stream().min((dep1, dep2) -> {
            double salary1 = dep1.getValue().getAverageSalary();
            double salary2 = dep2.getValue().getAverageSalary();
            return Double.compare(salary2, salary1);
        }).get().getValue().getName();
        System.out.printf("Highest Average Salary: %s%n",bestDepartment);
        departments.get(bestDepartment).getEmployeeList().stream()
                .sorted((e1,e2)-> (int) (e2.getSalary()-e1.getSalary()))
                .forEach(Employee::printEmployee);
    }

    public static Employee createEmployee(String[] input){
        String name = input[0];
        double salary = Double.parseDouble(input[1]);
        String position = input[2];
        String department = input[3];
        return new Employee(name,salary,position,department);
    }
}
