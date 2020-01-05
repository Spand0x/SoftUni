package spand0x;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String[] input = scanner.nextLine().split(" ");
        while(!"end".equals(input[0])){
            switch (input[0]){
                case "Add":
                    integerList.add(Integer.parseInt(input[1]));
                    break;
                case "Remove":
                    integerList.remove(integerList.indexOf(Integer.parseInt(input[1])));
                    break;
                case "RemoveAt":
                    integerList.remove(Integer.parseInt(input[1]));
                    break;
                case "Insert":
                    integerList.add(Integer.parseInt(input[2]),Integer.parseInt(input[1]));
                    break;
            }
            input = scanner.nextLine().split(" ");
        }
        for (int element :
                integerList) {
            System.out.print(element + " ");
        }
    }
}
