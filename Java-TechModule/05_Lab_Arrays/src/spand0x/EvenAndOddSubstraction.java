package spand0x;

import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubstraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sumEven = 0;
        int sumOdd = 0;
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int element :
                input) {
            if (element % 2 == 0) {
                sumEven += element;
            } else {
                sumOdd += element;
            }
        }
        System.out.println(sumEven-sumOdd);
    }
}
