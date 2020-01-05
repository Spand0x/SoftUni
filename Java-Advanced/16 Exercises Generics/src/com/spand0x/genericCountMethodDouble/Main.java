package com.spand0x.genericCountMethodDouble;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Box<Double>> list = new LinkedList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Double line = Double.parseDouble(scanner.nextLine());
            Box<Double> box = new Box<>(line);
            list.add(box);
        }
        Box<Double> check = new Box<>(Double.parseDouble(scanner.nextLine()));

        System.out.println(findOccurrences(list,check));

    }

    private static <T extends Comparable> long findOccurrences(List<Box<T>> boxes, Box<T> box){
        return boxes.stream().filter(b->0 < b.getElement().compareTo(box.getElement())).count();
    }
}
