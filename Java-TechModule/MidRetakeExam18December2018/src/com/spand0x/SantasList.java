package com.spand0x;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SantasList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> noisyKids = new ArrayList<String>();
        String[] kids = scanner.nextLine().split("&");
        for (String kid : kids) {
            noisyKids.add(kid);
        }
        String input = scanner.nextLine();
        while (!"Finished!".equalsIgnoreCase(input)) {
            String[] commands = input.split(" ");
            switch (commands[0]) {
                case "Bad":
                    if (!noisyKids.contains(commands[1])) {
                        noisyKids.add(0, commands[1]);
                    }
                    break;
                case "Good":
                    noisyKids.remove(commands[1]);
                    break;
                case "Rename":
                    if (noisyKids.contains(commands[1])) {
                        noisyKids.set(noisyKids.indexOf(commands[1]), commands[2]);
                    }
                    break;
                case "Rearrange":
                    if (noisyKids.contains(commands[1])) {
                        noisyKids.remove(commands[1]);
                        noisyKids.add(commands[1]);
                    }

                    break;

            }


            input = scanner.nextLine();

        }
        String result = noisyKids.toString().replaceAll("[\\[\\],]", "").trim();
        System.out.println(result.replaceAll(" ", ", "));
    }
}
