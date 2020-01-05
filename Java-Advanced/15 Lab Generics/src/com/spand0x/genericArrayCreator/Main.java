package com.spand0x.genericArrayCreator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = ArrayCreator.create(10,"none");
        Integer[] integers = ArrayCreator.create(Integer.class,10,0);
        System.out.println(strings);
    }
}
