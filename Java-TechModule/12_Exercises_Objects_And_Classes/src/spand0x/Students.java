package spand0x;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Student> studentList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String[] input = scanner.nextLine().split(" ");
            Student student = new Student(input[0],input[1],Double.parseDouble(input[2]));
            studentList.add(student);
        }
        studentList.stream().sorted(Comparator.comparing(Student::getGrade).reversed())
                .forEach(element -> System.out.printf("%s %s: %.2f\n",element.getFirstName(),element.getLastName(),element.getGrade()));
    }
}

class Student{
    private String firstName;
    private String lastName;
    private double grade;

    public Student(String firstName, String lastName, double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getGrade() {
        return grade;
    }
}
