package spand0x;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SumAdjacentEqualNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        ArrayList<Double> arrayList = new ArrayList<Double>();
        for(int i = 0; i < input.length ; i++){
            arrayList.add(input[i]);
        }

        for(int i = 0; i < arrayList.size() -1 ; i++){
            if(arrayList.get(i).equals(arrayList.get(i + 1))){
                arrayList.set(i,(arrayList.get(i) + arrayList.get(i+1)));
                arrayList.remove(i+1);
                i = -1;
            }
        }
        for (double element :
                arrayList) {
            System.out.print(decimalFormat.format(element) + " ");
        }

    }
}
