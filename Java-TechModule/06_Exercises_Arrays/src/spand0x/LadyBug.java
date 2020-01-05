package spand0x;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBug {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[fieldSize];
        int[] initialIndex = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int anInitialIndex : initialIndex) {
            if (anInitialIndex < arr.length && anInitialIndex >= 0) {
                arr[anInitialIndex] = 1;
            }
        }
        String[] input = scanner.nextLine().split(" ");
        while (!"end".equals(input[0])) {
            int ladyBugIndex = Integer.parseInt(input[0]);
            String position = input[1];
            int moveSpaces = Integer.parseInt(input[2]);
            if ("right".equals(position) && moveSpaces < 0) {
                position = "left";
                moveSpaces = Math.abs(moveSpaces);
            } else if ("left".equals(position) && moveSpaces < 0) {
                position = "right";
                moveSpaces = Math.abs(moveSpaces);
            }
            if (ladyBugIndex >= 0 && ladyBugIndex < arr.length && arr[ladyBugIndex] == 1 && moveSpaces>0) {
                switch (position) {
                    case "right":

                        for (int i = ladyBugIndex; i < arr.length; i += moveSpaces) {
                            if (i + moveSpaces < arr.length && i + moveSpaces > 0) {
//                                if (moveSpaces == 0) {
//                                    break;
//                                }
                                if (arr[i + moveSpaces] != 1) {
                                    arr[ladyBugIndex] = 0;
                                    arr[i + moveSpaces] = 1;
                                    break;
                                }
                            } else {
                                arr[ladyBugIndex] = 0;
                                break;
                            }
                        }
                        break;
                    case "left":
                        for (int i = ladyBugIndex; i >= 0; i -= moveSpaces) {
                            if (i - moveSpaces >= 0 && i - moveSpaces < arr.length) {
//                                if (moveSpaces == 0) {
//                                    break;
//                                }
                                if (arr[i - moveSpaces] != 1) {
                                    arr[ladyBugIndex] = 0;
                                    arr[i - moveSpaces] = 1;
                                    break;
                                }
                            } else {
                                arr[ladyBugIndex] = 0;
                                break;
                            }
                        }
                        break;
                }
            }
            input = scanner.nextLine().split(" ");
        }
        for (int element :
                arr) {
            System.out.print(element + " ");
        }
    }
}
