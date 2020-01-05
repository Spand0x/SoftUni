package com.spand0x;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsAndGrades = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);
            if(studentsAndGrades.containsKey(name)){
                studentsAndGrades.get(name).add(grade);
            }else {
                studentsAndGrades.put(name,new LinkedList<>());
                studentsAndGrades.get(name).add(grade);
            }
        }
        for (String name :
                studentsAndGrades.keySet()) {
            System.out.print(name + " -> ");
            double average = 0.0d;
            int count = 0;
            for(Double grade : studentsAndGrades.get(name)){
                average += grade;
                count++;
                System.out.printf("%.2f ",grade);
            }
            average = average/count;
            System.out.printf("(avg: %.2f)\n",average);
        }
    }
}
