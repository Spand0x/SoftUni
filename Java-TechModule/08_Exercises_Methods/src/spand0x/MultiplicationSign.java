package spand0x;

import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());
        int productSign = sign(num1) * sign(num2) * sign(num3);
        if (productSign < 0) {
            System.out.println("negative");
        }
        // negative
        else if (productSign > 0) {
            System.out.println("positive");
        }
        // positive
        else {
            System.out.println("zero");
        }
    }

    static int sign(int number) {
        if (number < 0)
            return -1;
        else if (number > 0)
            return 1;
        return 0;
    }
}
