package com.spand0x;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = size[0];
        int cols = size[1];
        String matrix[][] = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] arr = scanner.nextLine().split(" ");
            matrix[i] = arr;
        }
        String[] input = scanner.nextLine().split(" ");
        while (!input[0].equals("END")){ //check for negative too

            if(input.length != 5 || !input[0].equals("swap") || Integer.parseInt(input[1])>=rows ||
                    Integer.parseInt(input[3])>=rows || Integer.parseInt(input[2])>=cols || Integer.parseInt(input[4])>=cols){
                System.out.println("Invalid input!");
            }else{
                int row1 = Integer.parseInt(input[1]);
                int col1 = Integer.parseInt(input[2]);
                int row2 = Integer.parseInt(input[3]);
                int col2 = Integer.parseInt(input[4]);
                String firstCell = matrix[row1][col1];
                String secondCell = matrix[row2][col2];
                matrix[row1][col1] = secondCell;
                matrix[row2][col2] = firstCell;
                printMatrix(matrix);
            }
            input = scanner.nextLine().split(" ");
        }
    }
    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row <matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
