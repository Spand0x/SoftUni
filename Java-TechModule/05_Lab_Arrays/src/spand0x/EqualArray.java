package spand0x;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        int index = 0;
        boolean equal = true;
        for(int i = 0; i < firstArray.length; i++){
            if(firstArray[i] == secondArray[i]){
                sum+=firstArray[i];
            }
            else{
                equal = false;
                index=i;
                break;
            }
        }
        if(equal){
            System.out.println("Arrays are identical. Sum: " + sum);
        }else{
            System.out.println("Arrays are not identical. Found difference at " + index + " index");
        }

    }
}
