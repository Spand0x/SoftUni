package com.spand0x;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SpaceStationEstablishment {

    static Integer rowPosition = -1;
    static Integer colPosition = -1;
    static Integer starPower = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] galaxy = new char[size][size];
        //S = spaceship
        //digit = star
        //O = black hole;

//        int rowPosition = -1;
//        int colPosition = -1;

        List<Integer> rowBlackHole = new LinkedList<>();
        List<Integer> colBlackHole = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            char[] input = scanner.nextLine().toCharArray();
            for (int j = 0; j < size; j++) {
                galaxy[i][j] = input[j];
                if(input[j] == 'S'){
                    rowPosition = i;
                    colPosition = j;
                }
                if(input[j] == 'O'){
                    rowBlackHole.add(i);
                    colBlackHole.add(j);
                }
            }
            galaxy[i] = input;
        }
        boolean inGalaxy = true;
//        int starPower = 0;
        while (inGalaxy && starPower<50) {
            String command = scanner.nextLine();
            switch (command){
                case "up":
                    if(rowPosition==0){
                        inGalaxy = false;
                    }else {
                        galaxy[rowPosition][colPosition] = '-';
                        rowPosition = rowPosition-1;
                        if(Character.isDigit(galaxy[rowPosition][colPosition])){
                            digit(galaxy);
                        }else if(galaxy[rowPosition][colPosition] == 'O'){
                            blackHoles(galaxy,command,rowBlackHole,colBlackHole);
                        }else {
                            galaxy[rowPosition][colPosition] = 'S';
                        }
                    }
                    break;
                case "down":
                    if(rowPosition==size-1){
                        inGalaxy = false;
                    }else {
                        galaxy[rowPosition][colPosition] = '-';
                        rowPosition = rowPosition+1;
                        if(Character.isDigit(galaxy[rowPosition][colPosition])){
                            digit(galaxy);
                        }else if(galaxy[rowPosition][colPosition] == 'O'){
                            blackHoles(galaxy,command,rowBlackHole,colBlackHole);
                        }else {
                            galaxy[rowPosition][colPosition] = 'S';
                        }
                    }
                    break;
                case "left":
                    if(colPosition==0){
                        inGalaxy = false;
                    }else {
                        galaxy[rowPosition][colPosition] = '-';
                        colPosition = colPosition-1;
                        if(Character.isDigit(galaxy[rowPosition][colPosition])){
                            digit(galaxy);
                        }else if(galaxy[rowPosition][colPosition] == 'O'){
                            blackHoles(galaxy,command,rowBlackHole,colBlackHole);
                        }else {
                            galaxy[rowPosition][colPosition] = 'S';
                        }
                    }
                    break;
                case "right":
                    if(colPosition==size-1){
                        inGalaxy = false;
                    }else {
                        galaxy[rowPosition][colPosition] = '-';
                        colPosition = colPosition+1;
                        if(Character.isDigit(galaxy[rowPosition][colPosition])){
                            digit(galaxy);
                        }else if(galaxy[rowPosition][colPosition] == 'O'){
                            blackHoles(galaxy,command,rowBlackHole,colBlackHole);
                        }else {
                            galaxy[rowPosition][colPosition] = 'S';
                        }
                    }
                    break;
            }
        }
        if(!inGalaxy){
            galaxy[rowPosition][colPosition] = '-';
            System.out.println("Bad news, the spaceship went to the void.");
        }else if(starPower>=50){
            System.out.println("Good news! Stephen succeeded in collecting enough star power!");
        }
        System.out.println("Star power collected: " + starPower);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(galaxy[i][j]);
            }
            System.out.println();
        };

    }
    public static char[][] blackHoles(char[][] galaxy,String command,List<Integer> rowBlackHole,List<Integer> colBlackHole){
        int firstHoleRow = rowBlackHole.get(0);
        int firstHoleCol = colBlackHole.get(0);
        int secondHoleRow = rowBlackHole.get(1);
        int secondHoleCol = colBlackHole.get(1);
        if(firstHoleRow == rowPosition && firstHoleCol == colPosition){
            galaxy[rowPosition][colPosition] = '-';
            rowPosition = secondHoleRow;
            colPosition = secondHoleCol;
            galaxy[rowPosition][colPosition] = 'S';
        }else {
            galaxy[rowPosition][colPosition] = '-';
            rowPosition = firstHoleRow;
            colPosition = firstHoleCol;
            galaxy[rowPosition][colPosition] = 'S';
        }

        return galaxy;
    }
    public static char[][] digit(char[][] galaxy){
        int digit = Integer.parseInt(String.valueOf(galaxy[rowPosition][colPosition]));
        starPower+=digit;
        galaxy[rowPosition][colPosition] = 'S';
        return galaxy;
    }
}
