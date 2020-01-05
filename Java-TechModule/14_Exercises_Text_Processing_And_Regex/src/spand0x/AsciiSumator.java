package spand0x;

import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);
        int totalSum = 0;

        int start = Math.min(first,second);
        int end = Math.max(first,second);

        String input = scanner.nextLine();
        for( int i = 0; i < input.length(); i++){
            char currentChar = input.charAt(i);
            if(currentChar>start && currentChar<end){
                totalSum+=currentChar;
            }
        }

        System.out.println(totalSum);
    }
}
