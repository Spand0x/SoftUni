package spand0x;

import java.util.Scanner;


public class PascalTriangle {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		if(n == 0) {
			return;
		}
		else if(n == 1) {
			System.out.println(1);
			return;
		}

		System.out.println(1);
		System.out.println(1 + " " + 1);
		
		int[] previousRow = new int[n];
		int[] currentRow = new int[n];
		
		previousRow[0] = 1;
		previousRow[1] = 1;
		previousRow[previousRow.length-2] = 1;

		currentRow[0] = 1;
		currentRow[currentRow.length-1] = 1;
		
		for(int i = 2; i < n; i++) { //rows
						
			System.out.print(currentRow[0] + " ");
			for(int j = 1; j < i; j++) { //columns
				int temp = previousRow[j] + previousRow[j-1];
				currentRow[j] = temp;
				System.out.print(currentRow[j] + " ");
				if(currentRow.length != j-1) {
					currentRow[j+1] = 1;
				}
			}
			System.out.print(1);
			System.out.println();
			for(int k = 0; k <= i; k++) {
				previousRow[k] = currentRow[k];
			}
			
			
		}
	}

}
