package spand0x;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean print = false;
        for(int i = 0; i < input.length; i++) {
        	int sumLeft = 0;
            int sumRigth = 0;
        	for(int k = 0; k<i;k++) {
        		sumLeft+=input[k];
        	}
        	for(int k = input.length-1; k>i;k--) {
        		sumRigth+=input[k];
        	}
        	if(sumLeft==sumRigth) {
        		print = true;
        		System.out.println(i);
        	}
        }
        if(!print) {
        	System.out.println("no");
        }
	}

}
