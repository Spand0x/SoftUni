package spand0x;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String[] input = scanner.nextLine().split(" ");
        while (!"end".equals(input[0])) {
            switch (input[0]) {
                case "Contains":
                    if (integerList.contains(Integer.parseInt(input[1]))) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    switch (input[1]) {
                        case "even":
                            for (int i = 0; i < integerList.size(); i++) {
                                if (integerList.get(i) % 2 == 0) {
                                    System.out.print(integerList.get(i) + " ");
                                }
                            }
                            System.out.println();

                            break;
                        case "odd":
                            for (int element : integerList) {
                                if (element % 2 != 0) {
                                    System.out.print(element + " ");
                                }
                            }
                            System.out.println();
                            break;
                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (int element :
                            integerList) {
                        sum+=element;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    switch (input[1]){
                        case "<":
                            for (int element : integerList) {
                                if (element < Integer.parseInt(input[2])) {
                                    System.out.print(element + " ");
                                }
                                }
                            System.out.println();
                            break;
                        case ">":
                            for (int element : integerList) {
                                if (element > Integer.parseInt(input[2])) {
                                    System.out.print(element + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case "<=":
                            for (int element : integerList) {
                                if (element <= Integer.parseInt(input[2])) {
                                    System.out.print(element + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case ">=":
                            for (int element : integerList) {
                                if (element >= Integer.parseInt(input[2])) {
                                    System.out.print(element + " ");
                                }
                            }
                            System.out.println();
                            break;
                    }
                    break;
            }
            input = scanner.nextLine().split(" ");
        }
    }
}
