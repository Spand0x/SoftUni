package spand0x;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();
        double totalPrice = 0.0d;
        switch (type) {
            case "Students":
                switch (day) {
                    case "Friday":
                        totalPrice = number * 8.45;
                        break;
                    case "Saturday":
                        totalPrice = number * 9.80;
                        break;
                    case "Sunday":
                        totalPrice = number * 10.46;
                        break;
                }
                break;
            case "Business":
                switch (day) {
                    case "Friday":
                        totalPrice = number * 10.9;
                        break;
                    case "Saturday":
                        totalPrice = number * 15.6;
                        break;
                    case "Sunday":
                        totalPrice = number * 16;
                        break;
                }
                break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        totalPrice = number * 15;
                        break;
                    case "Saturday":
                        totalPrice = number * 20;
                        break;
                    case "Sunday":
                        totalPrice = number * 22.5;
                        break;
                }
                break;
        }
        if (type.equals("Students") && number >= 30) {
            totalPrice -= (totalPrice * 0.15);
        } else if (type.equals("Business") && number >= 100) {
            totalPrice -= (totalPrice / number) * 10;
        } else if (type.equals("Regular") && number >= 10 && number <= 20) {
            totalPrice -= totalPrice * 0.05;
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
