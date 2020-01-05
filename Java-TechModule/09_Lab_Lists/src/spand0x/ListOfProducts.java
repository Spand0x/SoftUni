package spand0x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> stringList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            stringList.add(scanner.nextLine());
        }
        Collections.sort(stringList);
        for(int i = 0; i < n; i++){
            System.out.println(i+1 + "." +stringList.get(i));
        }
    }
}
