package spand0x;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        int capacityPeople = Integer.parseInt(scanner.nextLine());
        int fullcourses = numberOfPeople/capacityPeople;
        int moreCourses = 0;
        if(numberOfPeople%capacityPeople != 0){
            moreCourses++;
        }
        System.out.println(fullcourses+moreCourses);
    }
}
