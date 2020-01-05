package com.spand0x;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> queue = new ArrayDeque<>();
        queue.push(1L);
        queue.push(1L);

        for(int i = 0; i < input;i++){
            long a = queue.poll();
            long b = queue.peek();
            long c = a+b;
            queue.add(c);
        }
        System.out.println(queue.getFirst());
    }


}
