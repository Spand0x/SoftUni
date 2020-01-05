package spand0x;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        switch(type){
            case "int":
                int firstNumber = Integer.parseInt(scanner.nextLine());
                int secondNumber = Integer.parseInt(scanner.nextLine());
                System.out.println(compareValues(firstNumber,secondNumber));
                break;
            case "char":
                char firstChar = scanner.nextLine().charAt(0);
                char secondChar = scanner.nextLine().charAt(0);
                System.out.println(compareValues(firstChar,secondChar));

                break;
            case "String":
                String first = scanner.nextLine();
                String second = scanner.nextLine();
                System.out.println(compareValues(first,second));

                break;
        }
    }

    private static int compareValues(int firstNumber, int secondNumber) {
        if(firstNumber>secondNumber){
            return firstNumber;
        }
        return secondNumber;
    }

    public static char compareValues(char firstChar, char secondChar){
        if(firstChar> secondChar){
            return firstChar;
        }
        return secondChar;
    }

    public static String compareValues(String first, String second){
        if(first.compareTo(second) >=0){
            return first;
        }
        return second;
    }
}
