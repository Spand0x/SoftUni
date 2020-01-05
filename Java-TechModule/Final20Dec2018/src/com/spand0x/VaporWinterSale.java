package com.spand0x;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VaporWinterSale {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        Map<String, Double> gameAndPrice = new LinkedHashMap<>();
        Map<String, String> gameAndDLC = new LinkedHashMap<>(); //maybe value is array.
        for(int i = 0; i < input.length; i++){
            if(input[i].contains("-")){
                String[] temp = input[i].split("-");
                String gameName = temp[0];
                double price = Double.parseDouble(temp[1]);
                gameAndPrice.put(gameName,price);
            }else if(input[i].contains(":")){
                String[] temp = input[i].split(":");
                String gameName = temp[0];
                String gameDLC = temp[1];
                if(gameAndPrice.containsKey(gameName)){
                    gameAndDLC.put(gameName,gameDLC);
                    gameAndPrice.put(gameName,gameAndPrice.get(gameName)*1.2);
                }

            }
        }
        for(String game : gameAndPrice.keySet()){
            if(gameAndDLC.containsKey(game)){
                gameAndPrice.put(game,gameAndPrice.get(game)*0.5);
            }else{
                gameAndPrice.put(game,gameAndPrice.get(game)*0.8);
            }
        }
        gameAndPrice.entrySet().stream().filter(e->gameAndDLC.containsKey(e.getKey())).sorted(Comparator.comparing(Map.Entry::getValue)).forEach(game->{
            System.out.printf("%s - %s - %.2f\n",game.getKey(), gameAndDLC.get(game.getKey()) , game.getValue());
        });
        gameAndPrice.entrySet().stream().filter(e->!gameAndDLC.containsKey(e.getKey())).sorted((e1,e2)-> e2.getValue().compareTo(e1.getValue())).forEach(game->{
            System.out.printf("%s - %.2f\n",game.getKey(), game.getValue());
        });

    }
}
