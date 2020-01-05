package vehiclesextension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carInfo = scanner.nextLine().split("\\s+");
        String[] truckInfo = scanner.nextLine().split("\\s+");
        String[] busInfo = scanner.nextLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));
        Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Double.parseDouble(truckInfo[3]));
        Bus bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");

            if (command[0].equals("Drive")) {
                if (command[1].equals("Car")) {
                    System.out.println(car.drive(Double.parseDouble(command[2])));
                } else if (command[1].equals("Truck")) {
                    System.out.println(truck.drive(Double.parseDouble(command[2])));
                }else if(command[1].equals("Bus")){
                    System.out.println(bus.drive(Double.parseDouble(command[2])));
                }
            } else if (command[0].equals("DriveEmpty")) {
                System.out.println(bus.driveEmpty(Double.parseDouble(command[2])));
            } else if (command[0].equals("Refuel")) {
                try {
                    if (command[1].equals("Car")) {
                        car.refuel(Double.parseDouble(command[2]));
                    } else if (command[1].equals("Truck")) {
                        truck.refuel(Double.parseDouble(command[2]));
                    }else if(command[1].equals("Bus")){
                       bus.refuel(Double.parseDouble(command[2]));
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());


    }
}
