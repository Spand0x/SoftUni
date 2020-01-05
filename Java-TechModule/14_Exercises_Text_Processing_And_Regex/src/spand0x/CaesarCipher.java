package spand0x;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = "";
        for(int i = 0; i < input.length(); i++){
            int character = input.charAt(i);
            result+= (char)(character+3);
        }
        System.out.println(result);
    }
}
