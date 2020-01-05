package com.spand0x;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Function<int[],Integer> findMin = x->{
            int min = Integer.MAX_VALUE;
            for (int number :
                    x) {
                if (min > number){
                    min = number;
                }
            }
            return min;
        };
        System.out.println(findMin.apply(input));
    }

}
