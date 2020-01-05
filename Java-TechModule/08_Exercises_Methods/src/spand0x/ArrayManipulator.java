package spand0x;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] intArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] input = scanner.nextLine().split(" ");
        while(!"end".equals(input[0])){
            String command = input[0];
            switch (command){
                case "exchange":
                    intArr = exchange(intArr, input[1]);
                    break;
                case "max":
                    switch (input[1]){
                        case "even":
                            maxEvenOrOdd(intArr,true);
                            break;
                        case "odd":
                            maxEvenOrOdd(intArr,false);
                            break;
                    }
                    break;
                case "min":
                    switch (input[1]){
                        case "even":
                            minEvenOrOdd(intArr,true);
                            break;
                        case "odd":
                            minEvenOrOdd(intArr,false);
                            break;
                    }
                    break;
                case "first":
                    switch (input[2]){
                        case "even":
                            firstEvenOrOdd(intArr,true,input[1]);
                            break;
                        case "odd":
                            firstEvenOrOdd(intArr,false,input[1]);
                            break;
                    }
                    break;
                case "last":
                    switch (input[2]){
                        case "even":
                            lastEvenOrOdd(intArr,true,input[1]);
                            break;
                        case "odd":
                            lastEvenOrOdd(intArr,false,input[1]);
                            break;
                    }
                    break;
            }
            input =scanner.nextLine().split(" ");
        }
        ArrayList<Integer> finalArr = new ArrayList<>();
        for (int element: intArr) {
            finalArr.add(element);
        }
        System.out.println(finalArr.toString());


    }



    private static int[] exchange(int[] intArr, String input) {

        int index = Integer.parseInt(input);
        if(index > intArr.length){
            System.out.println("Invalid index");
            return intArr;
        }else if(index == intArr.length){
            return intArr;
        }
        int leftArrLength = index+1;
        int rightArrLength = intArr.length - leftArrLength;
        int[] leftArr = new int[leftArrLength];
        int[] rightArr = new int[rightArrLength];
        int[] newArr = new int[intArr.length];
        for(int i = 0; i < leftArr.length ; i++){
            leftArr[i] = intArr[i];
        }
        for (int i = 0; i < rightArr.length ; i++){
            rightArr[i] = intArr[leftArrLength+i];
        }
        for(int i = 0; i < rightArr.length ; i++){
            newArr[i] = rightArr[i];
        }
        for(int i = 0; i < leftArr.length ; i++){
            newArr[rightArrLength+i] = leftArr[i];
        }
        return newArr;

    }


    private static void maxEvenOrOdd(int[] intArr, boolean isEven) {
        int lastNumber = Integer.MIN_VALUE;
        int index = -1;
        if(isEven){
            for(int i = 0; i < intArr.length ; i++){
                if(intArr[i] % 2 == 0){
                    if(lastNumber<=intArr[i]){
                        index = i;
                        lastNumber = intArr[i];
                    }
                }
            }
        }else{
            for(int i = 0; i <intArr.length; i++){
                if(intArr[i] % 2 != 0){
                    if(lastNumber<=intArr[i]){
                        index = i;
                        lastNumber = intArr[i];
                    }
                }
            }
        }
        if(index == -1){
            System.out.println("No matches");
        }else{
            System.out.println(index);
        }


    }


    private static void minEvenOrOdd(int[] intArr, boolean isEven) {
        int lastNumber = Integer.MAX_VALUE;
        int index = -1;
        if(isEven){
            for(int i = 0; i < intArr.length ; i++){
                if(intArr[i] % 2 == 0){
                    if(lastNumber>=intArr[i]){
                        index = i;
                        lastNumber = intArr[i];
                    }
                }
            }
        }else{
            for(int i = 0; i <intArr.length; i++){
                if(intArr[i] % 2 != 0){
                    if(lastNumber>=intArr[i]){
                        index = i;
                        lastNumber = intArr[i];
                    }
                }
            }
        }
        if(index == -1){
            System.out.println("No matches");
        }else{
            System.out.println(index);
        }
    }

    private static void firstEvenOrOdd(int[] intArr, boolean isEven, String input) {
        int inputCount = Integer.parseInt(input);
        int count = 0;
        ArrayList<Integer> printArr = new ArrayList<>();
        if(inputCount > intArr.length){
            System.out.println("Invalid count");
            return;
        }
        for(int i = 0; i < intArr.length ; i++){
            if(count == inputCount){
                break;
            }
            if(isEven){
                if(intArr[i] % 2 == 0){
                    printArr.add(intArr[i]);
                    count++;
                }
            }else{
                if(intArr[i] % 2 != 0){
                    printArr.add(intArr[i]);
                    count++;
                }

            }
        }
        System.out.println(printArr.toString());

    }

    private static void lastEvenOrOdd(int[] intArr, boolean isEven, String input) {
        int inputCount = Integer.parseInt(input);
        int count = 0;
        ArrayList<Integer> printArr = new ArrayList<>();
        if(inputCount > intArr.length){
            System.out.println("Invalid count");
            return;
        }
        for(int i = intArr.length-1; i >= 0 ; i--){
            if(count == inputCount){
                break;
            }
            if(isEven){
                if(intArr[i] % 2 == 0){
                    printArr.add(intArr[i]);
                    count++;
                }
            }else{
                if(intArr[i] % 2 != 0){
                    printArr.add(intArr[i]);
                    count++;
                }

            }
        }
        Collections.reverse(printArr);
        System.out.println(printArr.toString());

    }
}
