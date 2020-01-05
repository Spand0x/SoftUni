package animalfarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        Chicken chicken = null;
        try{
            chicken = new Chicken(name,age);
            System.out.println(chicken);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
