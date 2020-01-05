package com.spand0x;

import java.util.Scanner;

public class FillTheMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        char pattern = input[1].charAt(0);
        int[][] matrix = new int[n][n];
        if(pattern == 'A'){
            matrix = fillMatrixAType(matrix,n);

        }else{
            matrix = fillMatrixBType(matrix,n);
        }
        printMatrix(matrix);
    }

    private static int[][] fillMatrixBType(int[][] matrix, int n) {
        int count = 1;
        for (int col = 0; col < n; col++) {
            if(col%2==0) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = count;
                    count++;
                }
            }else {
                for(int row = n-1; row>=0; row--){
                    matrix[row][col] = count;
                    count++;
                }
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row <matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrixAType(int[][] matrix, int n) {
        int counter = 1;
        for (int col = 0; col < n; col++) {
            for (int row = 0; row <n; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
        return matrix;
    }
}
