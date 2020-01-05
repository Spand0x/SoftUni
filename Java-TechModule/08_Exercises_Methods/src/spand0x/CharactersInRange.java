package spand0x;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);
        printCharacters(firstChar,secondChar);
    }
    public static void printCharacters(char a, char b){
        char start;
        char end;
        if(b > a){
            start =a;
            end = b;
        }else {
            start = b;
            end = a;
        }
        for(int i = start+1;i<end;i++){
            System.out.print((char)i + " ");
        }
    }
}
