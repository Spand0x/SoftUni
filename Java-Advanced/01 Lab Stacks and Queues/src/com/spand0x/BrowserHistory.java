package com.spand0x;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String>  history = new ArrayDeque<>();
        while(!input.equals("Home")){
            if(history.size()<2 && input.equals("back")){
                System.out.println("no previous URLs");
            }else if(input.equals("back")){
                history.pop();
                System.out.println(history.peek());
            }else{
                history.push(input);
                System.out.println(input);
            }

            input = scanner.nextLine();
        }

    }
}
