package telephony;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = new LinkedList<>(Arrays.asList(scanner.nextLine().split("\\s+")));
        List<String> sites = new LinkedList<>(Arrays.asList(scanner.nextLine().split("\\s+")));
        Smartphone smartphone = new Smartphone(numbers,sites);
        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());


    }
}
