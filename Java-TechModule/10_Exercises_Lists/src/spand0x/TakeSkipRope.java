package spand0x;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Character> nonNumbers = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        for(int i = 0; i < input.length();i++){
            if(Character.isDigit(input.charAt(i))){
                numbers.add(Integer.parseInt(String.valueOf(input.charAt(i))));
            }else{
                nonNumbers.add(input.charAt(i));
            }
        }
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();
        for(int i = 0; i < numbers.size();i++){
            if(i%2==0){
                takeList.add(numbers.get(i));
            }else{
                skipList.add(numbers.get(i));
            }
        }
        for(int i = 0; i < takeList.size();i++){

        }
    }
}
