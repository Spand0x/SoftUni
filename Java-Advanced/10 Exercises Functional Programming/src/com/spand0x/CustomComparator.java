package com.spand0x;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer first, Integer second) {
                int result = 0;
                if(first %2 == 0 && second % 2 != 0){
                    result = -1;
                }else if(first % 2 != 0 && second % 2 == 0){
                    result = 1;
                }else {
                    result = first-second;
                }
                return result;
            }
        };

        numbers.sort(comparator);
        numbers.forEach(e->System.out.print(e + " "));
    }
}
