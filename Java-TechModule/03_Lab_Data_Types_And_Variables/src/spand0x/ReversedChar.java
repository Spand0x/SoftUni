package spand0x;

import java.util.Scanner;

public class ReversedChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char one = scanner.nextLine().charAt(0);
        char two = scanner.nextLine().charAt(0);
        char three = scanner.nextLine().charAt(0);
        String allChars = three+" "+two+" "+one;
        System.out.println(allChars);
    }
}
