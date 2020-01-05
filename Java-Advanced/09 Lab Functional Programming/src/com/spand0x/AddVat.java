package com.spand0x;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        List<Double> prices = new LinkedList<>();

        Function<String, Double> convert = Double::parseDouble;
        UnaryOperator<Double> addvat = x-> x * 1.2;
        System.out.println("Prices with VAT:");
        for (String number : input) {
            double digit = convert.apply(number);
            System.out.printf("%.2f\n",addvat.apply(digit));
        }
    }
}
