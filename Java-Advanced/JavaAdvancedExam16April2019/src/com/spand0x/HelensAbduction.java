package com.spand0x;

import java.util.Arrays;
import java.util.Scanner;

public class HelensAbduction {
    private static int parisRow = -1;
    private static int parisCol = -1;
    private static int energy = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        energy = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[size][];
        int helenRow = -1;
        int helenCol = -1;
        for (int i = 0; i < size; i++) {
            char[] input = scanner.nextLine().toCharArray();
            for (int j = 0; j < size; j++) {
                field[i][j] = input[j];
                if (input[j] == 'P') {
                    parisRow = i;
                    parisCol = j;
                } else if (input[j] == 'H') {
                    helenRow = i;
                    helenCol = j;
                }
            }
        }
        boolean foundHelen = false;
        while (energy > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            int rowSpawn = Integer.parseInt(input[1]);
            int colSpawn = Integer.parseInt(input[2]);
            field[rowSpawn][colSpawn] = 'S';


            switch (command) {
                case "up":
                    if (parisRow == 0) {
                        energy--;
                    } else {
                        field[parisRow][parisCol] = '-';
                        parisRow -= 1;
                        move(field);
                    }
                    break;
                case "down":
                    if (parisRow == size - 1) {
                        energy--;
                    } else {
                        field[parisRow][parisCol] = '-';
                        parisRow += 1;
                        move(field);
                    }
                    break;
                case "left":
                    if (parisCol == 0) {
                        energy--;
                    } else {
                        field[parisRow][parisCol] = '-';
                        parisCol -= 1;
                        move(field);
                    }
                    break;
                case "right":
                    if (parisCol == size - 1) {
                        energy--;
                    } else {
                        field[parisRow][parisCol] = '-';
                        parisCol += 1;
                        move(field);
                    }
                    break;
            }
            if (parisRow == helenRow && parisCol == helenCol) { //find where
                foundHelen = true;
                field[parisRow][parisCol] = '-';
                break;
            }
        }
        if(foundHelen){
            System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
        }else {
            System.out.printf("Paris died at %d;%d.%n",parisRow,parisCol);
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }

    }

    private static char[][] move(char[][] field) {
        if (field[parisRow][parisCol] == 'S') {
            energy -= 2;
        }
        energy--;
        if (energy <= 0) {
            field[parisRow][parisCol] = 'X';
        }else {
            field[parisRow][parisCol] = 'P';
        }
        return field;
    }
}
