package com.spand0x;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Map<String, String> nameEmails = new LinkedHashMap<>();
        while (!name.equalsIgnoreCase("stop")){
            String email = scanner.nextLine();
            if (!email.endsWith(".com") && !email.endsWith(".uk") && !email.endsWith(".us")) {
                nameEmails.put(name,email);
            }
            name = scanner.nextLine();
        }
        for (String key :
                nameEmails.keySet()) {
            System.out.println(key + " -> " + nameEmails.get(key));
        }

    }
}
