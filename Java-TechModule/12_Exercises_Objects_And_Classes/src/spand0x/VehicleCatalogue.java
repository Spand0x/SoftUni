package spand0x;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> carList = new ArrayList<>();
        List<Vehicle> truckList = new ArrayList<>();
        String input = scanner.nextLine();
        while(!"End".equalsIgnoreCase(input)){
            String[] command = input.split(" ");
            if(command[0].equalsIgnoreCase("car")){
                Vehicle vehicle = new Vehicle("Car",command[1],command[2],Integer.parseInt(command[3]));
                carList.add(vehicle);
            }else{
                Vehicle vehicle = new Vehicle("Truck",command[1],command[2],Integer.parseInt(command[3]));
                truckList.add(vehicle);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while(!"close the catalogue".equalsIgnoreCase(input)){
            for (Vehicle car :
                    carList) {
                if(car.getModel().equalsIgnoreCase(input)){
                    System.out.println(car.toString());
                }
            }
            for (Vehicle truck :
                    truckList) {
                if(truck.getModel().equalsIgnoreCase(input)){
                    System.out.println(truck.toString());
                }
            }

            input = scanner.nextLine();
        }
        double sumCars = 0;
        double countCars = 0;
        double sumTrucks = 0;
        double countTrucks = 0;
        for(Vehicle car : carList){
            sumCars += car.getHorsepower();
            countCars++;
        }
        for(Vehicle truck : truckList){
            sumTrucks += truck.getHorsepower();
            countTrucks++;
        }

        double averageCars = sumCars/countCars;
        double averageTrucks = sumTrucks/countTrucks;
        if(countCars==0){
            averageCars = 0;
        }
        if(countTrucks == 0){
            averageTrucks = 0;
        }
        System.out.printf("Cars have average horsepower of: %.2f.\n",averageCars);

        System.out.printf("Trucks have average horsepower of: %.2f.",averageTrucks);



    }
}

class Vehicle {
    private final String type;
    private String model;
    private String color;
    private int horsepower;

    public Vehicle(String type, String model, String color, int horsepower) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Type: " + this.type  +
                "\nModel: " + this.model +
                "\nColor: " + this.color +
                "\nHorsepower: " + this.horsepower;
    }
}