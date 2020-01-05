package com.spand0x;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] playerOneInput = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] playerTwoInput = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> deckOne = new LinkedHashSet<>();
        Set<Integer> deckTwo = new LinkedHashSet<>();
        for(int i = 0; i < 20; i++){
            deckOne.add(playerOneInput[i]);
            deckTwo.add(playerTwoInput[i]);
        }
        for(int i = 0; i < 50; i++){
            if(deckOne.isEmpty() || deckTwo.isEmpty()){
                break;
            }
            int playerOneCard = deckOne.iterator().next();
            deckOne.remove(playerOneCard);
            int playerTwoCard = deckTwo.iterator().next();
            deckTwo.remove(playerTwoCard);
            if(playerOneCard>playerTwoCard){
                deckOne.add(playerOneCard);
                deckOne.add(playerTwoCard);
            }else if(playerOneCard<playerTwoCard){
                deckTwo.add(playerOneCard);
                deckTwo.add(playerTwoCard);
            }
        }
        if(deckOne.size()>deckTwo.size()){
            System.out.println("First player win!");
        }else if(deckOne.size()<deckTwo.size()){
            System.out.println("Second player win!");
        }else{
            System.out.println("Draw!");
        }
    }
}
