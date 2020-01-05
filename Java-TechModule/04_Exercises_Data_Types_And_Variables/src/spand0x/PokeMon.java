package spand0x;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int originalN = n;
        int m = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());
        int count = 0;

        while(n>m){
            n -=m;
            if(originalN/2==n){
                if(y>0) {
                    n /= y;
                }
            }
            count++;

        }
        System.out.println(n);
        System.out.println(count);
    }
}
