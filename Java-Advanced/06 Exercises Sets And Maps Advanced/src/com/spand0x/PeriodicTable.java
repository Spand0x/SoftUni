package com.spand0x;

import com.sun.source.tree.Tree;

import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> periodic = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            periodic.addAll(Arrays.asList(input));
        }
        for (String element :
                periodic) {
            System.out.print(element+" ");
        };
    }
}
