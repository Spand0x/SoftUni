package spand0x;

import java.util.Scanner;

public class RefactoringPrimeCheck {
    public static void main(String[] args) {
        Scanner chetec = new Scanner(System.in);
        int input = Integer.parseInt(chetec.nextLine());
        for (int i = 2; i <= input; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", i, isPrime);
        }
    }
}
