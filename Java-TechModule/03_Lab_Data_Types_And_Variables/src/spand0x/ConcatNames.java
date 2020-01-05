package spand0x;

import java.util.Scanner;

public class ConcatNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        String secondname = scanner.nextLine();
        String delimeter = scanner.nextLine();
        System.out.println(firstName+delimeter+secondname);
    }
}
