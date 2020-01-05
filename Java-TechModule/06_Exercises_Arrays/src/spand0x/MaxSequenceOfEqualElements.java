package spand0x;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int oldCount = 0;
        int count = 0;
        int number = 0;
        for(int i = input.length-1; i >=0 ; i--) {
        	count = 0;
        	for(int k = i-1; k>=0;k--) {
            	if(input[i]==input[k]) {
            		count++;
            	}else {
            		break;
            	}
        	}
        	if(count>=oldCount) {
        		oldCount = count;
        		number = input[i];
        	}
        }
        for(int i = 0; i <= oldCount; i ++) {
        	System.out.print(number+ " ");
        }
	}
}
