package spand0x;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        while(!"end".equals(input[0])){
            if(input[0].equals("Add")){
                wagons.add(wagons.size(),Integer.parseInt(input[1]));
            }else {
                for(int i = 0; i < wagons.size() ; i++){
                    if(Integer.parseInt(input[0]) + wagons.get(i) <= maxCapacity){
                        wagons.set(i,(Integer.parseInt(input[0])+wagons.get(i)));
                        break;
                    }
                }
            }
            input = scanner.nextLine().split(" ");
        }
        System.out.println(wagons.toString().replaceAll("[\\[\\],]", ""));
    }
}
