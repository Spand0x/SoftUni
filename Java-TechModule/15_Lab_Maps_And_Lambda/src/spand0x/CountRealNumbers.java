package spand0x;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        TreeMap<Integer,Integer> numbers = new TreeMap<>();
        for (int i = 0; i < nums.length; i++){
            if(numbers.containsKey(nums[i])){
                numbers.put(nums[i],numbers.get(nums[i])+1);
            }else{
                numbers.put(nums[i],1);
            }
        }
        for (Map.Entry<Integer, Integer> key : numbers.entrySet()) {
            System.out.println(key.getKey() + " -> " + key.getValue());
        }

    }
}
