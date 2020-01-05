package com.spand0x;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstInfo = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int firstMatrixRow = firstInfo[0];
        int firstMatrixColumn = firstInfo[1];
        int[][] firstMatrix = new int[firstMatrixRow][firstMatrixColumn];
        for(int i = 0; i < firstMatrixRow; i++){
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            firstMatrix[i] = arr;
        }

        int[] secondInfo = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int secondMatrixRow = secondInfo[0];
        int secondMatrixColumn = secondInfo[1];
        int[][] secondMatrix = new int[secondMatrixRow][secondMatrixColumn];
        if(firstMatrixRow!=secondMatrixRow || firstMatrixColumn!=secondMatrixColumn){
            System.out.println("not equal");
            return;
        }

        for(int i = 0; i < secondMatrixRow; i++){
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            secondMatrix[i] = arr;
        }

        for(int i = 0; i < firstMatrixRow; i++){
            for(int j = 0; j < firstMatrixColumn; j++){
                if(firstMatrix[i][j] != secondMatrix[i][j]){
                    System.out.println("not equal");
                    return;
                }
            }
        }
        System.out.println("equal");




    }
}
