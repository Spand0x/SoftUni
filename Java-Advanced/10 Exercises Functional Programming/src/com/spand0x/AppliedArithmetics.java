package com.spand0x;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        String line = scanner.nextLine();
        while (!"end".equalsIgnoreCase(line)){
            if("print".equalsIgnoreCase(line)){
                numbers.forEach(number->System.out.print(number + " "));
                System.out.println();
            }else{
                numbers = funcMathOperations(numbers,line);
            }
            line = scanner.nextLine();
        }
    }

    private static List<Integer> funcMathOperations(List<Integer> numbers, String condition){
        Function<List<Integer>,List<Integer>> func = list-> {
            for (int i = 0; i < list.size(); i++) {
                if (condition.equalsIgnoreCase("add")) {
                    list.set(i,list.get(i)+1);
                } else if (condition.equalsIgnoreCase("multiply")) {
                    list.set(i,list.get(i)*2);
                } else if (condition.equalsIgnoreCase("subtract")) {
                    list.set(i,list.get(i)-1);
                }
            }
            return list;
        };
        return func.apply(numbers);
    }
}

