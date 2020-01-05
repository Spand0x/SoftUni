package com.spand0x.smartarray;

public class Main {
    public static void main(String[] args) {
        SmartArray test = new SmartArray();
        for (int i = 0; i < 4; i++) {
            test.add(i);
        }
        test.add(3,20);
        for (int i = 0; i < 4; i++) {
            System.out.println(test.get(i));
        }
    }
}
