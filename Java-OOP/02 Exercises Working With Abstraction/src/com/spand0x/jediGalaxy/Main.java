package com.spand0x.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimestions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimestions[0];
        int cols = dimestions[1];

        int[][] matrix = new int[rows][cols];

        createMatrix(matrix);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you"))
        {
            int[] ivo = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evil = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int rowEvil = evil[0];
            int colEvil = evil[1];

            while (rowEvil >= 0 && colEvil >= 0)
            {
                if (rowEvil >= 0 && rowEvil < matrix.length && colEvil >= 0 && colEvil < matrix[0].length)
                {
                    matrix[rowEvil] [colEvil] = 0;
                }
                rowEvil--;
                colEvil--;
            }

            int rowIvo = ivo[0];
            int colIvo = ivo[1];

            while (rowIvo >= 0 && colIvo < matrix[1].length)
            {
                if (rowIvo >= 0 && rowIvo < matrix.length && colIvo >= 0 && colIvo < matrix[0].length)
                {
                    sum += matrix[rowIvo][colIvo];
                }

                colIvo++;
                rowIvo--;
            }

            command = scanner.nextLine();
        }

        System.out.println(sum);
    }

    private static void createMatrix(int[][] matrix) {
        int value = 0;
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                matrix[i][j] = value++;
            }
        }
    }
}
