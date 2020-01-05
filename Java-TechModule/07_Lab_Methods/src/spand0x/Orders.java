package spand0x;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int qty = Integer.parseInt(scanner.nextLine());
        printOrder(product,qty);
    }

    private static void printOrder(String product, int qty) {
        double sum = 0.0d;
        switch (product){
            case "coffee":
                sum = 1.5 * qty;
                break;
            case "water":
                sum = qty;
                break;
            case "coke":
                sum = qty * 1.4;
                break;
            case "snacks":
                sum = 2* qty;
                break;
        }
        System.out.printf("%.2f", sum);
    }
}
