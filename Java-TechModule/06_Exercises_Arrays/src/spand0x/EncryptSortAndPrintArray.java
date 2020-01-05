import java.util.Scanner;

public class EncryptSortAndPrintArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		
		int[] result = new int[n];
		
		for(int i = 0; i < n; i++) {
			int vowel = 0;
			int consonant = 0;
			
			String input = scanner.nextLine();
			for(int j = 0; j < input.length(); j++) {
				int vowelTemp = 0;
				int consonantTemp = 0;
				char charFromInput = input.charAt(j);
				int codeOfChar = (int) charFromInput;
				
				switch (charFromInput) {
				case 'a':
				case 'e':
				case 'o':
				case 'i':
				case 'u':
				case 'A':
				case 'E':
				case 'O':
				case 'I':
				case 'U':
					vowelTemp = codeOfChar * input.length();
					break;
				default:
					consonantTemp = codeOfChar / input.length();
					break;
				}
				vowel+=vowelTemp;
				consonant+=consonantTemp;
			}
			result[i] = vowel+consonant;
		}
		
		for(int i = 0; i < result.length-1; i++) {
			for(int j = 0; j < result.length-1-i; j++) {
				if(result[j]>result[j+1]) {
					int temp = result[j];
					result[j] = result[j+1];
					result[j+1] = temp;
				}
			}
		}
		for (int element : result) {
			System.out.println(element);
		}

	}

}
