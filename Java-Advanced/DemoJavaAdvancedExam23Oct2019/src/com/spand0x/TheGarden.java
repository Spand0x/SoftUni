package com.spand0x;

import java.util.Scanner;

public class TheGarden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        char[][] garden = new char[rows][];
        for (int i = 0; i < rows; i++) {
            char[] input = scanner.nextLine().replaceAll(" ","").toCharArray();
            garden[i] = input;
        }
        int carrots = 0;
        int potatoes = 0;
        int lettuce = 0;
        int harmed = 0;
        String input = scanner.nextLine();
        while (!"End of Harvest".equalsIgnoreCase(input)){
            String[] line = input.split("\\s+");
            String command = line[0];
            int row = Integer.parseInt(line[1]);
            int col = Integer.parseInt(line[2]);
//            int gardenRows = garden.length;
//            int gardenCols = garden[row].length;
            if(command.equalsIgnoreCase("Harvest")){
                if(row>=0 && row<garden.length && col >=0 && col<garden[row].length){//maybe split in two IFS
                    if(garden[row][col] == 'C'){
                        carrots++;
                    } else if(garden[row][col] == 'P'){
                        potatoes++;
                    }else if(garden[row][col] == 'L'){
                        lettuce++;
                    }
                    garden[row][col] = ' ';
                }
            }else if(command.equalsIgnoreCase("Mole")){
                String direction = line[3];
                //check if mole is inside;
                if(row>=0 && row < garden.length && col >= 0 && col < garden[row].length) {
                    switch (direction.toLowerCase()) {
                        case "up":
                            for (int i = row; i >= 0; i -= 2) {
                                if (garden[i][col] != ' ') {
                                    harmed++;
                                }
                                garden[i][col] = ' ';
                            }
                            break;
                        case "down":
                            for (int i = row; i < garden.length; i += 2) {
                                if (garden[i][col] != ' ') {
                                    harmed++;
                                }
                                garden[i][col] = ' ';
                            }
                            break;
                        case "left":
                            for (int i = col; i >= 0; i -= 2) {
                                if (garden[row][i] != ' ') {
                                    harmed++;
                                }
                                garden[row][i] = ' ';
                            }
                            break;
                        case "right":
                            for (int i = col; i < garden[row].length; i += 2) {
                                if (garden[row][i] != ' ') {
                                    harmed++;
                                }
                                garden[row][i] = ' ';
                            }
                            break;

                    }
                }

            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < garden.length; i++) {
            for (int j = 0; j < garden[i].length; j++) {
                System.out.print(garden[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Carrots: " + carrots);
        System.out.println("Potatoes: " + potatoes);
        System.out.println("Lettuce: " + lettuce);
        System.out.println("Harmed vegetables: " + harmed);
    }
}
