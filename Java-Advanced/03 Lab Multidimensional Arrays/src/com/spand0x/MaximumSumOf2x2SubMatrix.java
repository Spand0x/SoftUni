package com.spand0x;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] info = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = info[0];
        int columns = info[1];
        int[][] matrix = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            int[] arr = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }
        int sum = 0;
        int indexRow = 0;
        int indexCol = 0;
        for(int i = 0; i < rows-1; i++){
            for(int j = 0; j < columns-1; j++){
                int newSum = 0;
                for(int rowIn = 0; rowIn <2; rowIn++){
                    for(int colIn = 0; colIn<2;colIn++){
                        newSum += matrix[rowIn+i][colIn+j];
                    }
                }
                if(newSum>sum){
                    sum = newSum;
                    indexRow = i;
                    indexCol = j;
                }
            }
        }

        for(int i = indexRow; i < indexRow+2; i++){
            for (int j = indexCol; j < indexCol+2; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(sum);
    }
}
