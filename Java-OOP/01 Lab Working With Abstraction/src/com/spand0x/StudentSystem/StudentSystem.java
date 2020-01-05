package com.spand0x.StudentSystem;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void ParseCommand(String[] args) {

        if (args[0].equals("Create")) {
            createStudent(args);
        } else if (args[0].equals("Show")) {
            var name = args[1];
            if (repo.containsKey(name)) {
                var student = repo.get(name);
                String view = String.format("%s is %s years old.", student.getName(), student.getAge());

                view += getGrade(student.getGrade());

                System.out.println(view);
            }
        }
    }

    private String getGrade(double grade) {
        if (grade >= 5.00) {
            return " Excellent student.";
        } else if (grade < 5.00 && grade >= 3.50) {
            return " Average student.";
        } else {
            return " Very nice person.";
        }
    }

    private void createStudent(String[] args) {
        var name = args[1];
        var age = Integer.parseInt(args[2]);
        var grade = Double.parseDouble(args[3]);
        if (!repo.containsKey(name)) {
            var student = new Student(name, age, grade);
            repo.put(name, student);
        }
    }
}
