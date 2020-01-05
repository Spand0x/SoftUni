package spand0x;

import java.util.Scanner;

public class FromLeftToRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            String[] leftAndRightInput = input.split(" ");
            long left = Long.parseLong(leftAndRightInput[0]);
            long right = Long.parseLong(leftAndRightInput[1]);
            int sum = 0;
//            if(left==0 && right<0){
//                System.out.println(0);
//                continue;
//            }
//            if(right == 0 && left<0){
//                System.out.println(0);
//                continue;
//            }
//            if(left<0){
//                left*=-1;
//            }
//            if(right<0){
//                right*=-1;
//            }
            if(left>right){
                while(left!=0){
                    sum += left%10;
                    left/=10;
                }
            }else{
                while (right!=0){
                    sum += right%10;
                    right/=10;
                }
            }
            System.out.println(Math.abs(sum));
        }
    }
}
