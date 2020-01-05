package com.spand0x;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];
        for(int i = 0; i < rows; i++){
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }
        int wrongRowPos = scanner.nextInt();
        int wrongColPos = scanner.nextInt();
        int wrongNumber = matrix[wrongRowPos][wrongColPos];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == wrongNumber){
                    int sum = 0;
                    if(i-1>=0 && matrix[i-1][j] != wrongNumber){
                        sum+=matrix[i-1][j];
                    }
                    if(i+1<rows && matrix[i+1][j] != wrongNumber){
                        sum+=matrix[i+1][j];
                    }
                    if(j-1>=0 && matrix[i][j-1] != wrongNumber){
                        sum+=matrix[i][j-1];
                    }
                    if(j+1<matrix[i].length && matrix[i][j+1] != wrongNumber){
                        sum+=matrix[i][j+1];
                    }
                    matrix[i][j] = sum;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
