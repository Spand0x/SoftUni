package spand0x;

import java.util.Scanner;

public class MetersToKilometers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int meters = Integer.parseInt(scanner.nextLine());
        System.out.printf("%.2f", ((double) meters / 1000));
    }
}
