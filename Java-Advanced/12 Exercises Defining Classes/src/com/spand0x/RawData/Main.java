package com.spand0x.RawData;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            int tirePressureIndex = 5;
            int tireAgeIndex = 6;
            List<Tire> tireList = new LinkedList<>();
            for (int j = 0; j < 4; j++) {
                double tirePressure = Double.parseDouble(input[tirePressureIndex]);
                int tireAge = Integer.parseInt(input[tireAgeIndex]);
                Tire tire = new Tire(tireAge, tirePressure);
                tireList.add(tire);
                tirePressureIndex += 2;
                tireAgeIndex += 2;
            }
            Car current = new Car(model,
                    new Engine(engineSpeed, enginePower),
                    new Cargo(cargoWeight, cargoType),
                    tireList);
            cars.add(current);
        }
        String input = scanner.nextLine();
        if ("fragile".equalsIgnoreCase(input)) {
            for (Car car : cars) {
                if (car.getCargo().getCargoType().equalsIgnoreCase(input)) {
                    List<Tire> tires = car.getTires();
                    for (Tire tire : tires) {
                        if (tire.getPressure() < 1) {
                            System.out.println(car.getModel());
                            break;
                        }
                    }
                }
            }
        } else if ("flamable".equalsIgnoreCase(input)) {
            for (Car car : cars) {
                if (car.getCargo().getCargoType().equalsIgnoreCase(input)) {
                    if(car.getEngine().getEnginePower()>250){
                        System.out.println(car.getModel());
                    }
                }
            }
        }

    }
}
