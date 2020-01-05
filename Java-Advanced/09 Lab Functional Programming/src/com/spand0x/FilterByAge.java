package com.spand0x;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = scanner.nextLine();
        }
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();
        Map<String, Integer> people = new LinkedHashMap<>();
        for (String line :
                lines) {
            String[] temp = line.split(", ");
            people.put(temp[0],Integer.parseInt(temp[1]));
        }
        Predicate<Integer> tester = createTester(condition, age);
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);
        printFilteredStudents(people, tester, printer);
        System.out.println();
    }

    private static void printFilteredStudents(Map<String, Integer> people,
                                              Predicate<Integer> tester,
                                              Consumer<Map.Entry<String, Integer>> printer) {
        for (Map.Entry<String, Integer> person : people.entrySet()){
            if(tester.test(people.get(person.getKey()))){
                printer.accept(person);
            }
        }
    }

    private static Consumer<Map.Entry<String, Integer>> createPrinter(String format) {
        Consumer<Map.Entry<String, Integer>> printer = null;

        if (format.equalsIgnoreCase("name age")) {
            printer = person -> System.out.println(person.getKey() + " - " + person.getValue());
        } else if (format.equalsIgnoreCase("name")) {
            printer = person -> System.out.println(person.getKey());
        } else if (format.equalsIgnoreCase("age")) {
            printer = person -> System.out.println(person.getValue());
        }
        return printer;
    }

    private static Predicate<Integer> createTester(String condition, int age) {
        Predicate<Integer> tester = null;
        if (condition.equalsIgnoreCase("younger")) {
            tester = x -> x <= age;
        } else if (condition.equalsIgnoreCase("older")) {
            tester = x -> x >= age;
        }
        return tester;
    }
}
