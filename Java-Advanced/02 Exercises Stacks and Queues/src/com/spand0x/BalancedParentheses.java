package com.spand0x;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Character> stack = new ArrayDeque<>();
        String input = scanner.nextLine();
        char[] parentheses = input.toCharArray();
        boolean isBalanced = true;
        for(int i = 0; i<parentheses.length;i++){
            char symbol = parentheses[i];
            if(symbol=='{' || symbol=='[' || symbol=='('){
                stack.push(symbol);
            }else{
                if(stack.isEmpty()){
                    isBalanced=false;
                    break;
                }
                switch (parentheses[i]){
                    case '}':
                        if(stack.pop()!='{'){
//                        stack.pop();
                            isBalanced=false;
                            break;
                        }
                        break;
                    case ']':
                        if(stack.pop()!='['){
//                        stack.pop();
                            isBalanced=false;
                            break;
                        }
                        break;
                    case ')':
                        if(stack.pop()!='('){
//                        stack.pop();
                            isBalanced=false;
                            break;
                        }
                        break;
                }
            }

        }
        if(isBalanced){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
