package com.spand0x;

import java.util.*;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int count = 0;
        int sum = 0;
        Function<String,Integer> convert = Integer::parseInt;
        for (String number :
                input) {
            sum += convert.apply(number);
            count++;
        }
        System.out.println("Count = " + count);
        System.out.println("Sum = " + sum);
    }
}
