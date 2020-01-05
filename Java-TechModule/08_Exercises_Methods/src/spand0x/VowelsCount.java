package spand0x;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        printVowels(input);
    }
    public static void printVowels(String input){
        int count = 0;
        for(int i = 0; i < input.length() ; i++){
            char character = input.charAt(i);
            switch (character){
                case 'A':
                case 'a':
                case 'O':
                case 'o':
                case 'I':
                case 'i':
                case 'E':
                case 'e':
                case 'U':
                case 'u':
                    count++;
                    break;
            }
        }
        System.out.println(count);
    }
}
