package com.spand0x;

import java.util.*;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] line = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> list = new LinkedList<>();
        for (int number : line) {
            list.add(number);
        }

        list.removeIf(num -> num % 2 !=0);
        System.out.println(list.toString().replaceAll("\\[","").replaceAll("]",""));
        list.sort(Integer::compareTo);
        System.out.println(list.toString().replaceAll("\\[","").replaceAll("]",""));

    }


}
