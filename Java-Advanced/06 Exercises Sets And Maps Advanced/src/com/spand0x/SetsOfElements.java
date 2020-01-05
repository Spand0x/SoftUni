package com.spand0x;

import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] n = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sizeOne = n[0];
        int sizeTwo = n[1];
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < sizeOne; i++) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < sizeTwo; i++) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int number :
                firstSet) {
            if(secondSet.contains(number)){
                System.out.print(number + " ");
            }
        }
    }
}
