package spand0x;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String[] command = scanner.nextLine().split(" ");
        while (!"end".equals(command[0])) {
            switch (command[0]) {
                case "Delete":
                    int remove = Integer.parseInt(command[1]);
                    integerList.removeIf(x -> x == remove);
                    break;
                case "Insert":
                    if(Integer.parseInt(command[2]) >= 0 && Integer.parseInt(command[2]) < integerList.size())
                    integerList.add(Integer.parseInt(command[2]), Integer.parseInt(command[1]));
                    break;
            }
            command = scanner.nextLine().split(" ");
        }
        for (int i = 0; i < integerList.size(); i++) {
            System.out.print(integerList.get(i) + " ");
        }
    }
}
