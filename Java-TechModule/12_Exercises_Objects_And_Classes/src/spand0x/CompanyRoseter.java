package spand0x;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompanyRoseter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Department> departments = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String[] input = scanner.nextLine().split(" ");

        }

    }
}

class Department{
    private String name;
    private List<Employee> employeeList;

    public Department(String name) {
        this.name = name;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}

class Employee{
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

}