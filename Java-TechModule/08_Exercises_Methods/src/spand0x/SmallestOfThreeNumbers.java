package spand0x;

import java.util.Scanner;

public class SmallestOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        printSmallest(a,b,c);
    }
    public static void printSmallest(int a, int b, int c){
        if(a<b){
            if(a<c){
                System.out.println(a);
            }else{
                System.out.println(c);
            }
        }else if(a<c){
            if(b<a){
                System.out.println(b);
            }else{
                System.out.println(a);
            }
        }else {
            System.out.println(c);
        }
    }
}
