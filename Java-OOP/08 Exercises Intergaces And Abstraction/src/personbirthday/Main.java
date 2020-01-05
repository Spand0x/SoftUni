package personbirthday;


import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String,Buyer> people = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            if(input.length == 4){ // citizen
                Buyer citizen = new Citizen(input[0],Integer.parseInt(input[1]),input[2],input[3]);
                people.putIfAbsent(input[0],citizen);
            }else{
                Buyer rebel = new Rebel(input[0],Integer.parseInt(input[1]),input[2]);
                people.putIfAbsent(input[0],rebel);
            }
        }

        String name = scanner.nextLine();
        int totalFood = 0;
        while (!"END".equalsIgnoreCase(name)){
            String finalName = name;
            people.entrySet().stream().filter(e->e.getKey().equals(finalName)).findFirst().ifPresent(e->e.getValue().buyFood());
            name = scanner.nextLine();
        }
        for (Map.Entry<String, Buyer> person :
                people.entrySet()) {
            totalFood+=person.getValue().getFood();
        }
        System.out.println(totalFood);

    }



}
