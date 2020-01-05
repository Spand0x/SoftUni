package com.spand0x;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];
        for(int i = 0; i < size; i++){
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }
        int sumPrimaryDiagonal = findSumOne(matrix);
        int sumSecondDiagonal = findSumTwo(matrix);
        int difference = sumPrimaryDiagonal-sumSecondDiagonal;
        System.out.println(Math.abs(difference));
    }

    private static int findSumTwo(int[][] matrix) {
        int sum = 0;
        for(int i = 0, j = matrix.length-1; i < matrix.length;i++,j--){
            sum+= matrix[i][j];
        }
        return sum;
    }

    private static int findSumOne(int[][] matrix) {
        int sum = 0;
        for(int i = 0; i < matrix.length; i++){
            sum+= matrix[i][i];
        }
        return sum;
    }

}
