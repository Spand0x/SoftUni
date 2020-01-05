import core.ManagerControllerImpl;
import core.interfaces.ManagerController;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagerController managerController = new ManagerControllerImpl();

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        while (!"Exit".equals(input[0])) {
            String command = input[0];
            String[] data = Arrays.stream(input).skip(1).toArray(String[]::new);
            String message = "";
            try {

                switch (command){
                    case "AddPlayer":
                        message = managerController.addPlayer(data[0],data[1]);
                        break;
                    case "AddCard":
                        message = managerController.addCard(data[0],data[1]);
                        break;
                    case "AddPlayerCard":
                        message = managerController.addPlayerCard(data[0],data[1]);
                        break;
                    case "Fight":
                        message = managerController.fight(data[0],data[1]);
                        break;
                    case "Report":
                        message = managerController.report();
                        break;
                }
                System.out.println(message);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine().split("\\s+");
        }
    }
}
