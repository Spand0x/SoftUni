package spand0x;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> combinedList = new ArrayList<>();
        List<Integer> result =new ArrayList<>();
        int endRange = 0;
        int startRange = 0;
        for(int i = 0, j = secondList.size()-1; i<firstList.size() && j>=0;i++,j--){
            combinedList.add(firstList.get(i));
            combinedList.add(secondList.get(j));
        }
        if(firstList.size()>secondList.size()){
            if(firstList.get(firstList.size()-1)>firstList.get(firstList.size()-2)){
                endRange = firstList.get(firstList.size()-1);
                startRange = firstList.get(firstList.size()-2);
            }else{
                endRange = firstList.get(firstList.size()-2);
                startRange = firstList.get(firstList.size()-1);
            }
        }else{
            if(secondList.get(secondList.size()-1)>secondList.get(secondList.size()-2)){
                endRange = secondList.get(secondList.size()-1);
                startRange = secondList.get(secondList.size()-2);
            }else{
                endRange = secondList.get(secondList.size()-2);
                startRange = secondList.get(secondList.size()-1);
            }
        }
        for(int i = 0; i < combinedList.size(); i++){
            if(combinedList.get(i) >startRange && combinedList.get(i) < endRange){
                result.add(combinedList.get(i));
            }
        }
        Collections.sort(result);
        for (int element :
                result) {
            System.out.print(element +" ");
        }
    }
}
