package com.spand0x;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        int divider = Integer.parseInt(scanner.nextLine());
        Collections.reverse(numbers);
        numbers.removeIf(x->x%divider==0);
        numbers.forEach(x->System.out.print(x + " "));
    }
}
