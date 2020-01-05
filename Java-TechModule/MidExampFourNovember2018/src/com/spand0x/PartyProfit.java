package com.spand0x;

import java.util.Scanner;

public class PartyProfit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int partySize = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int gold = 0;
        for(int i = 1; i <= days;i++){
            if(i%10==0){
                partySize-=2;
            }
            if(i%15==0){
                partySize+=5;
            }
            gold +=50;
            gold = gold-(2*partySize);
            if(i%3==0){
                gold = gold-(3*partySize);
            }
            if(i%5==0){
                gold = gold + (20*partySize);
                if(i%3==0){
                    gold = gold - (2*partySize);
                }

            }

        }
        System.out.println(partySize + " companions received " + (gold/partySize) + " coins each.");
    }
}
