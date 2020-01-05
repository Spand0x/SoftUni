package motocrossWorldChampionship.core;

import motocrossWorldChampionship.core.interfaces.ChampionshipController;
import motocrossWorldChampionship.core.interfaces.Engine;

import java.util.Scanner;

public class EngineImpl implements Engine {
    private ChampionshipController championshipController;

    public EngineImpl(ChampionshipController championshipController) {
        this.championshipController = championshipController;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        String message = "";
        while (!"End".equals(input[0])) {
            String command = input[0];
            try {
                switch (command) {
                    case "CreateRider":
                        message = this.championshipController.createRider(input[1]);
                        break;
                    case "CreateMotorcycle":
                        message = this.championshipController.createMotorcycle(input[1], input[2], Integer.parseInt(input[3]));
                        break;
                    case "AddMotorcycleToRider":
                        message = this.championshipController.addMotorcycleToRider(input[1], input[2]);
                        break;
                    case "AddRiderToRace":
                        message = this.championshipController.addRiderToRace(input[1], input[2]);
                        break;
                    case "CreateRace":
                        message = this.championshipController.createRace(input[1], Integer.parseInt(input[2]));
                        break;
                    case "StartRace":
                        message = this.championshipController.startRace(input[1]);
                        break;
                }
                System.out.println(message);
            }catch (IllegalArgumentException | NullPointerException e){
                System.out.println(e.getMessage());
            }



            input = scanner.nextLine().split("\\s+");
        }
    }
}
