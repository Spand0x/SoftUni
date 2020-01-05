package com.spand0x.genericCountMethodString;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Box<String>> list = new LinkedList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            Box<String> box = new Box<>(line);
            list.add(box);
        }
        Box<String> check = new Box<>(scanner.nextLine());

        System.out.println(findOccurrences(list,check));

    }

    private static <T extends Comparable> long findOccurrences(List<Box<T>> boxes, Box<T> box){
        return boxes.stream().filter(b->0 < b.getElement().compareTo(box.getElement())).count();
    }
}
