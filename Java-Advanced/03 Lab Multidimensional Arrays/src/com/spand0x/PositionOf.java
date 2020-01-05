package com.spand0x;

import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] info = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = info[0];
        int columns = info[1];
        int[][] matrix = new int[rows][columns];

        for(int i = 0; i < rows; i++){
            int[] line = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = line;
        }

        int searched = Integer.parseInt(scanner.nextLine());
        boolean found = false;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(matrix[i][j] == searched){
                    System.out.println(i + " " + j);
                    found = true;
                }
            }
        }
        if(!found){
            System.out.println("not found");
        }

    }
}
