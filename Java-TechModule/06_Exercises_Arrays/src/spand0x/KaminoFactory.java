package spand0x;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int bestIndex = 0;
		int index = 0;
		int bestSum = 0;
		int sum = 0;
		int count = 0;
		int bestCount = 0;
		int bestPosition = 0;
		int position = 0;
		int n = Integer.parseInt(scanner.nextLine());
		int[] result = new int[n];
		String input = scanner.nextLine();
		while(!"Clone them!".equals(input)) {
			position++;
			count = 0;
			index = 0;
			sum = 0;
			int[] array = Arrays.stream(input.split("!+")).mapToInt(Integer::parseInt).toArray();
			for(int i = 0; i < array.length; i++) {
				if(array[i]==1) {
					sum++;
				}
			}
			for(int i = array.length-1; i >=0 ; i--) {
	        	for(int k = i-1; k>=0;k--) {
	            	if(array[i]==array[k] && array[i]==1) {
	            		index = k;
	            		count++;
	            	}else {
	            		break;
	            	}
	        	}
	        	
	        }
			if(count>0&&index==0) {
				count++;
			}
			if(count>bestCount) {
				bestCount = count;
				bestSum = sum;
				bestIndex = index;
				result = array;
				bestPosition = position;
			}
			else if(count==bestCount) {
				if(index<bestIndex) {
					bestCount = count;
					bestSum = sum;
					bestIndex = index;
					result = array;
					bestPosition = position;
				}
				else if(index == bestIndex) {
					if(sum>bestSum) {
						bestCount = count;
						bestSum = sum;
						bestIndex = index;
						result = array;
						bestPosition = position;
					}
				}
			}
			
			input = scanner.nextLine();
		}
		System.out.println("Best DNA sample " + bestPosition + " with sum: " + bestSum + ".");
		for (int i : result) {
			System.out.print(i+" ");
		}
	}
}
