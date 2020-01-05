package com.spand0x;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<List<Integer>> matrix = new ArrayList<>();
        matrix = fillMatrix(matrix,dimensions);

        String input = scanner.nextLine();
        while(!input.equalsIgnoreCase("Nuke it from orbit")){
            matrix = nukeIt(matrix,input);
            input = scanner.nextLine();
        }

            matrix.stream().forEach(x->{
                x.stream().forEach(y-> System.out.print(y+ " "));
                System.out.println();
            });


    }

    private static List<List<Integer>> nukeIt(List<List<Integer>> matrix, String input) {
        int row = Integer.parseInt(String.valueOf(input.charAt(0)));
        int col = Integer.parseInt(String.valueOf(input.charAt(2)));
        int rad = Integer.parseInt(String.valueOf(input.charAt(4)));

        int startCol = col-rad;
        int startRow = row-rad;
       for(int i = 0; i < rad*2+1; i++){
           try {
               matrix.get(row).remove(startCol);
               matrix.get(startRow+i).remove(col);  //delete 2 times. fixx
           } catch (Exception e) {

           }
       }
        return matrix;
    }

    private static List<List<Integer>> fillMatrix(List<List<Integer>> matrix, int[] dimensions) {
        int rows = dimensions[0];
        int cols = dimensions[0];
        int count = 1;
        for(int i = 0; i < rows;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                list.add(count);
                count++;
            }
            matrix.add(list);
        }
        return matrix;
    }
}
