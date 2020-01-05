package com.spand0x;

import java.util.Arrays;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] chessBoard = new char[8][8];
        for(int i = 0; i < 8; i++){
            String[] line = scanner.nextLine().split(" ");
            for(int j = 0; j < line.length;j++){
                chessBoard[i][j] = line[j].charAt(0);
            }
        }
        int finalQueenRow = -1;
        int finalQueenCol = -1;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if(chessBoard[row][col] == 'q'){
                    boolean isColValid = checkQueenCol(chessBoard,col);
                    boolean isRowValid = checkQueenRow(chessBoard,row);
                    int startCol = 0;
                    int startRow = 0;
                    if(col>=row){
                        startCol = col-row;
                    }else {
                        startRow = row-col;
                    }
                    boolean isDiagonalLeftValid = checkQueenDiagonalLeft(chessBoard,startRow,startCol);
                }
            }
        }
        System.out.println(finalQueenRow + " " + finalQueenCol);
    }

    private static boolean checkQueenDiagonalLeft(char[][] chessBoard, int startRow, int startCol) {
        int queensCount = 0;
        if(startRow%2==0){
            if(startRow>startCol){

            }else{

            }
            for(int i = startRow,j=startCol; i<8-startRow && j<8-startCol;i++,j++){
                if(chessBoard[i][j]=='q'){
                    queensCount++;
                }
            }
        }
        return queensCount == 1;
    }

    private static boolean checkQueenRow(char[][] chessBoard, int row) {
        int queensCount = 0;
        for(int i = 0; i < chessBoard.length;i++){
            char symbol = chessBoard[i][row];
            if(symbol == 'q'){
                queensCount++;
            }
        }
        return queensCount==1;
    }

    private static boolean checkQueenCol(char[][] chessBoard, int col) {
        int queensCount = 0;
        for(int i = 0; i < chessBoard.length;i++){
            char symbol = chessBoard[i][col];
            if(symbol == 'q'){
                queensCount++;
            }
        }
        return queensCount==1;
    }

}
