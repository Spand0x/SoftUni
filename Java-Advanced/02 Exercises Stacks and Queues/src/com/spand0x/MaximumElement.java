package com.spand0x;

import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < commands; i++){
            int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            if(input[0] == 1){
                stack.push(input[1]);
            }else if(input[0] == 2){
                stack.pop();
            }else if(input[0] == 3){
                System.out.println(Collections.max(stack));
            }
        }
    }
}
