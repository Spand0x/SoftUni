package spand0x;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        String input = scanner.nextLine();
        while (true) {
            if (input.contains(key)) {
                input = input.replace(key,"");
            } else {
                break;
            }
        }


        System.out.println(input);
    }
}
