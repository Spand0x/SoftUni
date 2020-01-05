package spand0x;

import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        if(a>b&& a>c){
            System.out.println(a);
            if(b>c){
                System.out.println(b);
                System.out.println(c);
            }else{
                System.out.println(c);
                System.out.println(b);
            }
        }else if(b>c && b>a){
            System.out.println(b);
            if(a>c){
                System.out.println(a);
                System.out.println(c);
            }else{
                System.out.println(c);
                System.out.println(a);
            }
        }else if(c>b && c>a){
            System.out.println(c);
            if(b>a){
                System.out.println(b);
                System.out.println(a);
            }else{
                System.out.println(a);
                System.out.println(b);
            }
        }

    }
}
