package spand0x;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String reverse = "";
        for (int i = 1; i <= input.length(); i++) {
            reverse = reverse + input.charAt(input.length() - i);
        }
        System.out.println(reverse);
    }
}
