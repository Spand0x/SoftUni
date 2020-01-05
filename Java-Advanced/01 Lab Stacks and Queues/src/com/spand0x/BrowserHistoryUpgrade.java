package com.spand0x;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String>  history = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();
        while(!input.equals("Home")){
            if(history.size()<2 && input.equals("back")){
                System.out.println("no previous URLs");
            }else if(input.equals("back")){
                String forwardLink = history.pop();
                forward.addFirst(forwardLink);
                System.out.println(history.peek());
            }else if(input.equals("forward") && forward.isEmpty()){
                System.out.println("no next URLs");
            }else if(input.equals("forward")){
                String backLink = forward.peek();
                history.push(backLink);
                System.out.println(forward.remove());
            }else{
                history.push(input);
                System.out.println(input);
                forward.clear();;
            }
            input = scanner.nextLine();
        }

    }
}
