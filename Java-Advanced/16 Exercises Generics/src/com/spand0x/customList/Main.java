package com.spand0x.customList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> test = new CustomList<>();
        String[] input = scanner.nextLine().split("\\s+");
        while (!"end".equalsIgnoreCase(input[0])){
            switch (input[0]){
                case "Add":
                    test.add(input[1]);
                    break;
                case "Remove":
                    test.remove(Integer.parseInt(input[1]));
                    break;
                case "Contains":
                    System.out.println(test.contains(input[1]));
                    break;
                case "Swap":
                    test.swap(Integer.parseInt(input[1]),Integer.parseInt(input[2]));
                    break;
                case "Greater":
                    System.out.println(test.countGreaterThan(input[1]));
                    break;
                case "Max":
                    System.out.println(test.getMax());
                    break;
                case "Min":
                    System.out.println(test.getMin());
                    break;
                case "Print":
                    test.forEach(System.out::println);
                    break;
            }
            input = scanner.nextLine().split("\\s+");
        }
    }
}
