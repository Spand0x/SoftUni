package com.spand0x;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        Map<Double,Integer> numbers = new LinkedHashMap<>();
        for(int i = 0; i < input.length;i++){
            if(numbers.containsKey(input[i])){
                numbers.put(input[i],numbers.get(input[i])+1);
            }else {
                numbers.put(input[i],1);
            }
        }
        for(Double key : numbers.keySet()){
            System.out.printf("%.1f -> %d \n",key,numbers.get(key));
        }
    }
}
