package com.spand0x.genericBoxOfIntegers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Integer input = Integer.parseInt(scanner.nextLine());
            Box box = new Box(input);
            System.out.println(box.toString());
        }
    }
}
