package spand0x;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> schedule = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String[] input = scanner.nextLine().split(":");
        while (!"course start".equals(input[0])){
            switch (input[0]){
                case "Add":
                    if(!schedule.contains(input[1])){
                        schedule.add(input[1]);
                    }
                    break;
                case "Insert":
                    if(!schedule.contains(input[1])){
                        schedule.add(Integer.parseInt(input[2]),input[1]);
                    }
                    break;
                case "Remove":
                    if(schedule.contains(input[1])){
                        schedule.remove(input[1]);
                        schedule.remove(input[1]+"-Exercise");
                    }
                    break;
                case "Swap":
                    if(schedule.contains(input[1]) && schedule.contains(input[2])){
                        int firstLessionIndex = schedule.indexOf(input[1]);
                        int secondLessionIndex = schedule.indexOf(input[2]);
                        schedule.set(firstLessionIndex,input[2]);
                        schedule.set(secondLessionIndex,input[1]);
                        if(schedule.contains(input[1]+"-Exercise")){
                            schedule.remove(input[1]+"-Exercise");
                            schedule.add(schedule.indexOf(input[1])+1,input[1]+"-Exercise");
                        }
                        if(schedule.contains(input[2]+"-Exercise")){
                            schedule.remove(input[2]+"-Exercise");
                            schedule.add(schedule.indexOf(input[2])+1,input[2]+"-Exercise");
                        }
                    }
                    break;
                case "Exercise":
                    if(schedule.contains(input[1]) && !schedule.contains(input[1]+"-Exercise")){
                        int indexOfLession = schedule.indexOf(input[1]);
                        schedule.add(indexOfLession+1,input[1]+"-Exercise");
                    }else if(!schedule.contains(input[1])){
                        schedule.add(input[1]);
                        schedule.add(input[1]+"-Exercise");
                    }
                    break;
            }
            input = scanner.nextLine().split(":");
        }
        for (int i = 0; i < schedule.size(); i++) {
            System.out.println(i+1 + "." + schedule.get(i));
        }
    }
}
