package com.spand0x;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        int n = input[0];
        int s = input[1];
        int x = input[2];
        int[] numbersArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            stack.push(numbersArray[i]);
        }
        for(int i = 0; i < s; i++){
            stack.pop();
        }
        if(stack.contains(x)){
            System.out.println(true);
        }else if(stack.isEmpty()){
            System.out.println(0);
        }else {
            int minNumber = Integer.MAX_VALUE;
            for(int element : stack){
                if(element<minNumber){
                    minNumber = element;
                }
            }
            System.out.println(minNumber);
        }

    }
}
