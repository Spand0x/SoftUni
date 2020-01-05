package spand0x;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCommands = Integer.parseInt(scanner.nextLine());
        List<String> people = new ArrayList<>();
        for(int i = 0; i < numOfCommands; i++){
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            if(input[2].equals("going!")){
                boolean isInList = false;
                for(int j = 0; j < people.size();j++){
                    if(people.get(j).equals(name)){
                        isInList=true;
                    }
                }
                if(isInList){
                    System.out.println(name + " is already in the list!");
                }else{
                    people.add(name);
                }
            }else if(input[2].equals("not")){
                boolean isInList = false;
                for(int j = 0; j < people.size(); j++){
                    if(people.get(j).equals(name)){
                        isInList = true;
                    }
                }
                if(isInList){
                    people.remove(name);
                }else {
                    System.out.println(name + " is not in the list!");
                }
            }
        }
        for (String name :
                people) {
            System.out.println(name);
        }
    }
}
