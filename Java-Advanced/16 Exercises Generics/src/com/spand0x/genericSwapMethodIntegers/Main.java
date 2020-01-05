package com.spand0x.genericSwapMethodIntegers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int line = Integer.parseInt(scanner.nextLine());
            list.add(line);
        }
        int[] indexes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int firstIndex = indexes[0];
        int secondIndex = indexes[1];
        list = swap(list,firstIndex,secondIndex);
        list.forEach(e-> System.out.println(e.getClass().getName() + ": " + e));

    }

    private static <T> List<T> swap(List<T> list, int indexOne, int indexTwo){
        T first = list.get(indexOne);
        list.set(indexOne,list.get(indexTwo));
        list.set(indexTwo,first);
        return list;
    }
}
