package spand0x;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while(!"END".equals(input)){
            checkIfPalindrome(input);


            input = scanner.nextLine();
        }
    }

    private static void checkIfPalindrome(String input) {
        for(int i = 0, j = input.length()-1; i < input.length() ; i++, j--){
            if(input.charAt(i) != input.charAt(j)){
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
