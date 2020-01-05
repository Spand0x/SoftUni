package spand0x;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        int digit = 0;
        int sum = 0;
        while(input>0){
            digit = input%10;
            sum+=digit;
            input/=10;
        }
        System.out.println(sum);
    }

}
