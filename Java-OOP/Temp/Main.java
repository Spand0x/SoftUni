import core.ManagerControllerImpl;
import core.interfaces.ManagerController;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        ManagerController managerController = new ManagerControllerImpl();
        while (!input[0].equals("Exit")) {
            String message = "";
                    String command = input[0];
            try {
                switch (command) {
                    case "AddPlayer":
                        message = managerController.addPlayer(input[1], input[2]);
                        break;
                    case "AddCard":
                        message = managerController.addCard(input[1], input[2]);
                        break;
                    case "AddPlayerCard":
                        message = managerController.addPlayerCard(input[1], input[2]);
                        break;
                    case "Fight":
                        message = managerController.fight(input[1], input[2]);
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
