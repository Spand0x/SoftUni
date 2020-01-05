package spand0x;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> stringList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String[] input = scanner.nextLine().split(" ");
        while (!"3:1".equals(input[0])) {
            if ("merge".equals(input[0])) {
                int startIndex = Integer.parseInt(input[1]);
                int endIndex = Integer.parseInt(input[2]);
                if (startIndex < 0) {
                    startIndex = 0;
                }
                if (endIndex >= stringList.size()) {
                    endIndex = stringList.size() - 1;
                }
                for (int i = startIndex; i < endIndex; i++) {
                    stringList.set(startIndex, stringList.get(startIndex) + stringList.get(startIndex + 1));
                    stringList.remove(startIndex + 1);
                }
            } else {
                int index = Integer.parseInt(input[1]);
                int partitions = Integer.parseInt(input[2]);
                String element = stringList.get(index);
                boolean equal = false;
                int pieces = element.length() / partitions;
                if (element.length() % partitions == 0) {
                    equal = true;
                }


                String[] chars = new String[partitions];
                for (int i = 0, j = 0; i < partitions; i++, j += pieces) {
                    if (!equal && i == partitions - 1) {
                        chars[i] = element.substring(j);
                    }else {
                        chars[i] = element.substring(j, j + pieces);
                    }
                }
                stringList.remove(index);
                for (int i = partitions - 1; i >= 0; i--) {
                    stringList.add(index, chars[i]);
                }
                System.out.println();

            }


            input = scanner.nextLine().split(" ");
        }
        for (String element : stringList) {
            System.out.print(element + " ");
        }
    }
}
