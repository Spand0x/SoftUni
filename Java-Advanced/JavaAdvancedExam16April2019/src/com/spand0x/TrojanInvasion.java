package com.spand0x;


import java.util.*;

public class TrojanInvasion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfWaves = Integer.parseInt(scanner.nextLine());
        List<Integer> plates = new LinkedList<>();
        List<Integer> warriors = new LinkedList<>();
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int plate :
                input) {
            plates.add(plate);
        }
        for(int i = 1; i <= numberOfWaves; i++){
            if(plates.isEmpty()){
                break;
            }
            int[] wave = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int warrior: wave){
                warriors.add(warrior);
            }
            if(i%3==0){
                int additional = Integer.parseInt(scanner.nextLine());
                plates.add(additional);
            }
            while (!warriors.isEmpty() && !plates.isEmpty()) {
                int plate = plates.get(0);
                int warrior = warriors.get(warriors.size()-1);
                if (plate > warrior) {
                    warriors.remove(warriors.size() - 1);
                    plate -= warrior;
                    plates.set(0, plate);
                } else if (warrior > plate) {
                    plates.remove(plates.size() - 1);
                    warrior -= plate;
                    warriors.set(warriors.size() - 1, warrior);
                } else {
                    warriors.remove(warriors.size() - 1);
                    plates.remove(0);
                }
            }
        }
        if (warriors.isEmpty()){
            System.out.print("The Spartans successfully repulsed the Trojan attack.\nPlates left: ");
            System.out.println(plates.toString().replaceAll("[\\[\\]]",""));

        }else{
            System.out.print("The Trojans successfully destroyed the Spartan defense.\nWarriors left: ");
            Collections.reverse(warriors);
            System.out.println(warriors.toString().replaceAll("[\\[\\]]",""));
        }
    }
}
