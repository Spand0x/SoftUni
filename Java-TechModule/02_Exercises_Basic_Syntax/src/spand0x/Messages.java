package spand0x;

import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            int mainDigit = 0;
            int countDigits = 0;
            int offset = 0;
            if (input == 0) {
                System.out.print(" ");
            } else {
                while (input > 0) {
                    mainDigit = input % 10;
                    input = input / 10;
                    countDigits++;
                }
                if (mainDigit == 8 || mainDigit == 9) {
                    offset = ((mainDigit - 2) * 3) + 1;
                } else {
                    offset = ((mainDigit - 2) * 3);
                }
                int letterIndex = (offset + countDigits - 1);
                char letter = (char) (letterIndex + 97);
                System.out.print(letter);
            }
        }


    }
}
