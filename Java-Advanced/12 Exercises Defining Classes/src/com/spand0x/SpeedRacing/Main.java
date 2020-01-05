package com.spand0x.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String,Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelCost = Double.parseDouble(input[2]);
            Car current = new Car(model,fuelAmount,fuelCost);
            cars.putIfAbsent(model,current);
        }
        String[] input = scanner.nextLine().split("\\s+");
        while (!"end".equalsIgnoreCase(input[0])){
            String model = input[1];
            double kilometers = Double.parseDouble(input[2]);
            cars.get(model).drive(kilometers);
            input = scanner.nextLine().split("\\s+");
        }
        cars.forEach((key, value) -> value.print());
    }
}
