package spand0x;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i<input.length; i++) {
        	for(int k = i+1; k<input.length; k++) {
        		if(input[i]+input[k] == n) {
        			System.out.println(input[i] + " " + input[k]);
        		}
        	}
        }

	}

}
