package com.spand0x.CarSalesman;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = createEngines(n);
        System.out.println();
        int m = Integer.parseInt(scanner.nextLine());
        List<Car> cars = createCars(m, engines);
        for (Car car: cars) {
            System.out.println(car.toString());
        }


    }

    private static List<Car> createCars(int lines,List<Engine> engineList) {
        List<Car> carList = new LinkedList<>();
        for (int i = 0; i < lines; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            String engine = input[1];
            Car currentCar;
            Engine currentEngine = engineList.stream().filter(e->e.getModel().equalsIgnoreCase(engine)).findFirst().get();
            if(input.length==2){
                currentCar = new Car(model,currentEngine);
            }else if(input.length == 3){
                currentCar = new Car(model,currentEngine,input[2]);
            }else{
                currentCar = new Car(model,currentEngine,input[2],input[3]);
            }
            carList.add(currentCar);
        }
        return carList;
    }

    private static List<Engine> createEngines(int n) {
        List<Engine> engines = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int power = Integer.parseInt(input[1]);
            Engine currentEngine;
            if(input.length==2){
                currentEngine = new Engine(model,power);
            }else if(input.length==3){
                currentEngine = new Engine(model,power,input[2]);
            }else{
                currentEngine = new Engine(model,power,input[2],input[3]); //check if double check is needed
            }
            engines.add(currentEngine);
        }
        return engines;
    }
}
