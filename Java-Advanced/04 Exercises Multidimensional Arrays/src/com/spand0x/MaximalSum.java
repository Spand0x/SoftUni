package com.spand0x;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in );
        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = size[0];
        int cols = size[1];
        int matrix[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }
        int sum = 0;
        int startRow = 0;
        int startCol = 0;
        for (int i = 0; i < rows-2; i++) {
            for (int j = 0; j < cols-2; j++) {
                int newSum = 0;
                for(int rowIn = 0; rowIn<3;rowIn++){
                    for(int colIn = 0; colIn<3;colIn++){
                        newSum += matrix[rowIn+i][colIn+j];
                    }
                }
                if(newSum>sum){
                    sum = newSum;
                    startRow = i;
                    startCol = j;
                }
            }
        }
        System.out.println("Sum = " + sum);
        for(int i = startRow;i<startRow+3; i++){
            for(int j = startCol ; j<startCol+3 ; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
