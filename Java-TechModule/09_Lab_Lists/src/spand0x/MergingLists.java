package spand0x;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        if(firstList.size()>secondList.size()){
            for(int i = 0; i < secondList.size();i++){
                result.add(firstList.get(i));
                result.add(secondList.get(i));
            }
            for(int i = secondList.size(); i < firstList.size() ; i++){
                result.add(firstList.get(i));
            }
        }else if(firstList.size()<secondList.size()){
            for(int i = 0; i < firstList.size();i++){
                result.add(firstList.get(i));
                result.add(secondList.get(i));
            }
            for(int i = firstList.size(); i < secondList.size() ; i++){
                result.add(secondList.get(i));
            }

        }else{
            for(int i = 0; i < secondList.size();i++){
                result.add(firstList.get(i));
                result.add(secondList.get(i));
            }
        }
        for (int element :
                result) {
            System.out.print(element + " ");
        }
    }
}
