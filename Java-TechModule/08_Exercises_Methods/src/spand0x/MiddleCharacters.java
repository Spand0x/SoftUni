package spand0x;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(middleChar(input));
    }

    private static String middleChar(String input){
        String result = "";
        if(input.length()%2==0){
            result = input.charAt(input.length()/2-1) + "" + input.charAt(input.length()/2);
        }else{
            result = input.charAt(input.length()/2) +"";
        }
        return result;
    }
}
