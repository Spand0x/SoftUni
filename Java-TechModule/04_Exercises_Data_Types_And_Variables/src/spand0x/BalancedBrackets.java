package spand0x;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        boolean isBalanced = false;
        boolean openBracket = false;
        int count = 0;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if(input.charAt(0) == '(' && openBracket){
                isBalanced = false;
                count++;
                break;
            }
            if(input.charAt(0) == '('){
                openBracket = true;
                count++;
                continue;
            }
            if(input.charAt(0) == ')' && openBracket){
                isBalanced = true;
                openBracket = false;
                count++;
                continue;
            }
            if(input.charAt(0) == ')' && !openBracket){
                isBalanced=false;
                count++;
                break;
            }


        }
        if(isBalanced){
            if(count%2==0){
                System.out.println("BALANCED");
            }
            else{
                System.out.println("UNBALANCED");
            }
        }else{
            System.out.println("UNBALANCED");
        }
    }
}
