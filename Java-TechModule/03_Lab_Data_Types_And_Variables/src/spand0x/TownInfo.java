package spand0x;

import java.util.Scanner;

public class TownInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String town = scanner.nextLine();
        int populatio = Integer.parseInt(scanner.nextLine());
        int area = Integer.parseInt(scanner.nextLine());
        System.out.println("Town "+town+ " has population of "+populatio+" and area "+area+" square km.");
    }
}
