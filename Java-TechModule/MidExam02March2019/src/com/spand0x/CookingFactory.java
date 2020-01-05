package com.spand0x;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CookingFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("#");
        List<Integer> bestProduct = new ArrayList<>();
        int bestQuality = Integer.MIN_VALUE;
        int greaterAverage = Integer.MIN_VALUE;
        int bestLength = Integer.MIN_VALUE;

        while (!"Bake It!".equalsIgnoreCase(input[0])) {
            List<Integer> listInput = new ArrayList<>();
            for (String element : input) {
                listInput.add(Integer.parseInt(element));
            }
            int currentQuality = 0;
            for (int element : listInput) {
                currentQuality += element;
            }
            if (currentQuality > bestQuality) {
                bestQuality = currentQuality;
                bestLength = listInput.size();
                greaterAverage = currentQuality / bestLength;

                bestProduct = listInput;
            } else if (currentQuality == bestQuality) {
                if (currentQuality / listInput.size() > greaterAverage) {
                    bestQuality = currentQuality;
                    bestLength = listInput.size();
                    greaterAverage = currentQuality / bestLength;

                    bestProduct = listInput;
                } else if (currentQuality / listInput.size() == greaterAverage) {
                    if (listInput.size() < bestLength) {
                        bestQuality = currentQuality;
                        bestLength = listInput.size();
                        greaterAverage = currentQuality / bestLength;

                        bestProduct = listInput;
                    }
                }

            }
            input = scanner.nextLine().split("#");
        }
        System.out.println("Best Batch quality: " + bestQuality);
        for(int element : bestProduct){
            System.out.print(element +" ");
        }
    }
}
