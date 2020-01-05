package spand0x;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int consume = 0;
        int count = 0;
        while(n>=100){

            consume= (consume+n)-26;
            n-=10;
            count++;
        }
        if(consume<26){
            consume-=n;
        }else {
            consume -= 26;
        }
        System.out.println(count);
        if(count == 0){
            System.out.println(0);
        }else {
            System.out.println(consume);
        }
    }
}
