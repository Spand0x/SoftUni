package com.spand0x;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputHouses = Arrays.stream(scanner.nextLine().split("@")).mapToInt(Integer::parseInt).toArray();
        List<Integer> houses = new ArrayList<>();
        for(int element : inputHouses){
            houses.add(element);
        }
        String input = scanner.nextLine();
        int currentIndex = 0;
        while(!"Merry Xmas!".equalsIgnoreCase(input)){
            String[] commands = input.split(" ");
            int jumpLength = Integer.parseInt(commands[1]);
            if(currentIndex+ jumpLength>= houses.size()){
                int rolls = (jumpLength + currentIndex) / houses.size();
                jumpLength = jumpLength - (rolls*houses.size());
            }
            currentIndex = currentIndex + jumpLength;
            if(houses.get(currentIndex) == 0){
                System.out.println("House " + currentIndex + " will have a Merry Christmas.");
            }else{
                houses.set(currentIndex, houses.get(currentIndex)-2);
            }


            input = scanner.nextLine();
        }
        System.out.println("Santa's last position was " + currentIndex +".");
        int doneHouses = 0;
        for(int house : houses){
            if(house == 0){
                doneHouses++;
            }
        }
        if(doneHouses==houses.size()){
            System.out.println("Mission was successful.");
        }else{
            System.out.printf("Santa has failed %d houses.", (houses.size()-doneHouses));
        }
    }
}
