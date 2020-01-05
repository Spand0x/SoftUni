package com.spand0x;

import java.util.*;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        Set<String> cars = new HashSet<>();
        while (!input[0].equals("END")){
            if(input[0].equalsIgnoreCase("in")){
                cars.add(input[1]);
            }else {
                cars.remove(input[1]);
            }
            input = scanner.nextLine().split(", ");
        }
        if(cars.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            cars.forEach(System.out::println);
        }
    }
}
