package spand0x;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSnowballs = Integer.parseInt(scanner.nextLine());
        double snowballValue = 0.0d;
        double highestValue = 0.0d;
        int highSnow = 0;
        int highTime = 0;
        int highQuality = 0;

        for (int i = 0; i < numberOfSnowballs; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            snowballValue = Math.pow(((double)snowballSnow/snowballTime), snowballQuality);
            if(snowballValue>highestValue){
                highSnow=snowballSnow;
                highTime= snowballTime;
                highQuality=snowballQuality;
                highestValue = snowballValue;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)",highSnow,highTime,highestValue,highQuality);
    }
}
