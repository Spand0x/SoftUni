package spand0x;

import java.util.Scanner;

public class MultiplyEvenByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        input = Math.abs(input);
        System.out.println(multiplyEvenAndOdds(input));

    }

    public static int multiplyEvenAndOdds(int number){
        int sumEven = sumEvenNumbers(number);
        int sumOdd = sumOddNumbers(number);
        return sumEven*sumOdd;
    }

    public static int sumEvenNumbers(int number){
        int sum = 0;
        while(number > 0){
            int digit = number%10;
            if(digit%2==0){
                sum+=digit;
            }
            number/=10;
        }
        return sum;
    }


    public static int sumOddNumbers(int number){
        int sum = 0;
        while(number > 0){
            int digit = number%10;
            if(digit%2!=0){
                sum+=digit;
            }
            number/=10;
        }
        return sum;
    }
}
