package spand0x;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> intList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).
                        collect(Collectors.toList());
        String[] input = scanner.nextLine().split(" ");
        while(!"End".equals(input[0])) {
            switch (input[0]) {
                case "Add":
                    intList.add(intList.size(), Integer.parseInt(input[1]));
                    break;
                case "Insert":
                    int index = Integer.parseInt(input[2]);
                    int number = Integer.parseInt(input[1]);
                    if(index < 0 || index > intList.size()) {
                        System.out.println("Invalid index");
                    }else {
                        intList.add(index, number);
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(input[1]);
                    if(index < 0 || index > intList.size()) {
                        System.out.println("Invalid index");
                    }else {
                        intList.remove(Integer.parseInt(input[1]));
                    }
                    break;
                case "Shift":
                    switch (input[1]) {
                        case "left":
                            intList = shiftLeft(intList,Integer.parseInt(input[2]));
                            break;
                        case "right":
                            intList = shiftRight(intList,Integer.parseInt(input[2]));
                            break;
                    }
                    break;
            }
            input = scanner.nextLine().split(" ");
        }

        for(int element : intList) {
            System.out.print(element + " ");
        }
    }

    private static List<Integer> shiftLeft(List<Integer> intList, int count){
        for(int i = 0; i < count; i ++) {
            int first = intList.get(0);
            for(int j = 0; j < intList.size()-1 ; j++) {
                intList.set(j, intList.get(j+1));
            }
            intList.set(intList.size()-1, first);
        }

        return intList;
    }

    private static List<Integer> shiftRight(List<Integer> intList, int count){
        for(int i = 0; i < count; i ++) {
            int last = intList.get(intList.size()-1);
            for(int j = intList.size()-1; j >0 ; j--) {
                intList.set(j, intList.get(j-1));
            }
            intList.set(0, last);
        }

        return intList;
    }

}