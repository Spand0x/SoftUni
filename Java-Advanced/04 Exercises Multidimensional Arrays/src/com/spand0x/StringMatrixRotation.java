package com.spand0x;

import java.util.ArrayDeque;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rotationInput = scanner.nextLine();

        String input = scanner.nextLine();
        ArrayDeque<String> inputQueue = new ArrayDeque<>();
        while (!input.equalsIgnoreCase("end")){
            inputQueue.offer(input);
            input = scanner.nextLine();
        }
        int lineLength = findLength(inputQueue);
        char[][] matrix = new char[inputQueue.size()][lineLength];
        int size = inputQueue.size();
        for(int i = 0; i<size;i++){
            String line = inputQueue.remove();
            for(int j = 0; j < line.length(); j++){
                matrix[i][j] = line.charAt(j);
            }
        }
        rotationInput = rotationInput.replaceAll("\\D+","");
        int rotation = Integer.parseInt(rotationInput);
        if(rotation % 360 == 0 || rotation == 0){
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < lineLength; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }else if(rotation % 360 == 270){
            for (int row = lineLength-1; row>=0 ;row--){
                for(int col = 0; col<size;col++){
                    System.out.print(matrix[col][row]);
                }
                System.out.println();
            }
        }else if(rotation % 360 == 180){
            for (int row = size-1; row >= 0 ; row--) {
                for(int col = lineLength-1; col >= 0 ; col--){
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }else if(rotation % 360 == 90){
            for(int row = 0; row <lineLength; row++){
                for(int col = size-1; col>=0;col--){
                    System.out.print(matrix[col][row]);
                }
                System.out.println();
            }
        }
    }


    private static int findLength(ArrayDeque<String> queue) {
        int largest = 0;
        int size = queue.size();
        for (int i = 0; i<size;i++){
            String line = queue.remove();
            if(line.length() >= largest){
                largest = line.length();
            }
            queue.offer(line);
        }
        return largest;
    }
}
