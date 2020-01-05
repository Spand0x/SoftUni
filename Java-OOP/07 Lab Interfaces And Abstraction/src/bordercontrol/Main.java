package bordercontrol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Robot> robots = new ArrayList<>();
        List<Citizen> citizens = new ArrayList<>();
        String[] input = scanner.nextLine().split("\\s+");
        while (!"END".equalsIgnoreCase(input[0])) {
            if (input.length == 3) {
                citizens.add(new Citizen(input[0], Integer.parseInt(input[1]), input[2]));
            } else {
                robots.add(new Robot(input[0], input[1]));
            }
            input = scanner.nextLine().split("\\s+");
        }
        String fakeID = scanner.nextLine();
        for (Robot robot :
                robots) {
            if (robot.getId().endsWith(fakeID)) {
                System.out.println(robot.getId());
            }
        }
        for (Citizen citizen :
                citizens) {
            if (citizen.getId().endsWith(fakeID)) {
                System.out.println(citizen.getId());
            }
        }
    }
}
