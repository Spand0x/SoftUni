package spand0x;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArrayString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        for (int i = 0; i < input.length / 2; i++) {
            String last = input[input.length - i - 1];
            input[input.length - 1 - i] = input[i];
            input[i] = last;
        }
        for (String element : input) {
            System.out.print(element + " ");
        }
    }
}
