package com.spand0x;

import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String,Double> nameAndGrades = new TreeMap<>();
        for(int i = 0; i < n; i++){
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            double average = 0.0d;
            double count = 0;
            for(int j = 0; j < grades.length; j++){
                average+=grades[j];
                count++;
            }
            average/=count;
            nameAndGrades.put(name,average);
        }
        for (String name :
                nameAndGrades.keySet()) {
            System.out.println(name + " is graduated with " + nameAndGrades.get(name));
        }
    }
}
