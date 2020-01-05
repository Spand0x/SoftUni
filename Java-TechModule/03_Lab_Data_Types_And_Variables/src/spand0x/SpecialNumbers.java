package spand0x;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 1; i<=n;i++){
            System.out.print(i + " -> ");
            int temp = i;
            int digit = 0;
            while(temp>0){
                digit += temp%10;
                temp /=10;
            }
            if(digit == 5 || digit == 7 || digit == 11){
                System.out.print("True\n");
            }else{
                System.out.print("False\n");
            }
        }
    }
}
