package spand0x;

import java.util.*;
public class TopInteger {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean check = false;
        for(int i = 0; i < input.length; i++) {
        	check = true;
        	for(int j = i+1; j<input.length; j++) {
        		if(input[i] <= input[j]) {
        			check = false;
        		}
        	}
        	if(check) {
        		System.out.print(input[i] + " ");
        	}
        }
        //System.out.println(input[input.length-1]);
       
    }
}

