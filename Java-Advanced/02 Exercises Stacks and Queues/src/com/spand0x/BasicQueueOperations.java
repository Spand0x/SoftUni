package com.spand0x;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        int n = input[0];
        int s = input[1];
        int x = input[2];

        int[] numbersArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        for(int i = 0; i < n; i++){
            queue.add(numbersArray[i]);
        }
        for(int i = 0; i < s; i++){
            queue.poll();
        }
        if(queue.contains(x)){
            System.out.println(true);
        }else{
            if(queue.isEmpty()){
                System.out.println(0);
            }else {
                System.out.println(Collections.min(queue));
            }
        }


    }
}
