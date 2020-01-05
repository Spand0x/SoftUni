package spand0x;

import java.util.Scanner;

public class DigitsLettersAndOthers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String letters = "";
        String numbers = "";
        String others = "";
        for(int i = 0; i < input.length();i++){
            char temp = input.charAt(i);
            if(Character.isDigit(temp)){
                numbers+=temp;
            }else if(Character.isLetter(temp)){
                letters+=temp;
            }else {
                others+=temp;
            }
        }
        System.out.println(numbers);
        System.out.println(letters);
        System.out.println(others);
    }
}
