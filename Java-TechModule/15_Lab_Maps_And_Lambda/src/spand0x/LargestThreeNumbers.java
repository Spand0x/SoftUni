package spand0x;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        if(list.size()>=3){
            for(int i = 0; i < 3; i++){
                System.out.print(list.get(i)+ " ");
            }
        }else{
            System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
