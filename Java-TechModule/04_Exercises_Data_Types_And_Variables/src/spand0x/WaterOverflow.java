package spand0x;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int capacity = 0;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            if(capacity+input >255){
                System.out.println("Insufficient capacity!");
            }else{
                capacity+=input;
            }
        }
        System.out.println(capacity);
    }
}
