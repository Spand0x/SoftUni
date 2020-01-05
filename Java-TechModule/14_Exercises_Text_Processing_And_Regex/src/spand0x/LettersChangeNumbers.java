package spand0x;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        double totalSum = 0;
        for (String word : input) {
            int firstLetter = 0;
            boolean firstUpper = false;
            int lastLetter = 0;
            boolean lastUpper = false;
            String digit = "";
            for(int i = 0; i < word.length(); i++){
                if(i==0){
                    if(Character.isUpperCase(word.charAt(0))){
                        firstLetter = word.charAt(0)-64;
                        firstUpper = true;
                    }else{
                        firstLetter = word.charAt(0)-96;
                    }
                }else if(i==word.length()-1){
                    if(Character.isUpperCase(word.charAt(word.length()-1))){
                        lastLetter = word.charAt(word.length()-1)-64;
                        lastUpper = true;
                    }else{
                        lastLetter = word.charAt(word.length()-1)-96;
                    }
                }else{
                    digit += word.charAt(i);
                }
            }
            double number = Double.parseDouble(digit);
            if(firstUpper){
                number/=firstLetter;
            }else {
                number*=firstLetter;
            }
            if(lastUpper){
                number-=lastLetter;
            }else {
                number+=lastLetter;
            }
            totalSum+=number;
        }
        System.out.printf("%.2f",totalSum);
    }
}
