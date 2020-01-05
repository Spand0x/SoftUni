package com.spand0x;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> printer = new ArrayDeque<>();

        while(!input.equals("print")){
            if(input.equals("cancel")){
                if(printer.isEmpty()){
                    System.out.println("Printer is on standby");
                }else{
                    System.out.println("Canceled " + printer.poll());
                }
            }else{
                printer.add(input);
            }
            input = scanner.nextLine();
        }

        for (String fileName :
                printer) {
            System.out.println(fileName);
        }

    }
}
