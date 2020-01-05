package spand0x;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        integerList.removeIf(n -> n < 0);
        Collections.reverse(integerList);
        if(integerList.isEmpty()){
            System.out.println("empty");
        }else{
            System.out.println(integerList.toString().replaceAll("[\\[\\],]",""));
        }
    }
}
