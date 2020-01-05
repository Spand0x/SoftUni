package com.spand0x;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix = new char[rows][columns];
        char[][] secondMatrix = new char[rows][columns];
        for(int i = 0; i < rows; i++){
            String[] line = scanner.nextLine().split(" ");
            for(int j = 0; j < columns; j++){
                firstMatrix[i][j] = line[j].charAt(0);
            }
        }
        for(int i = 0; i < rows; i++){
            String[] line = scanner.nextLine().split(" ");
            for(int j = 0; j < columns; j++){
                secondMatrix[i][j] = line[j].charAt(0);
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(firstMatrix[i][j] != secondMatrix[i][j]){
                    firstMatrix[i][j] = '*';
                }
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j<columns; j++){
                System.out.print(firstMatrix[i][j] + " ");
            }
            System.out.println();
        }


    }
}
