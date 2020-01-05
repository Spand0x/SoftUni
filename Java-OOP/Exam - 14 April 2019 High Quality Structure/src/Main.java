import core.MachineFactoryImpl;
import core.MachinesManagerImpl;

import core.PilotFactoryImpl;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PilotFactory pilotFactory = new PilotFactoryImpl();
        MachineFactory machineFactory = new MachineFactoryImpl();
        Map<String, Pilot> pilots = new LinkedHashMap<>();
        Map<String, Machine> machines = new LinkedHashMap<>();

        MachinesManager machinesManager = new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);

        String message = "";
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        while (!"Over".equals(input[0])){
            String command = input[0];
            switch (command){
                case "Hire":
                    message = machinesManager.hirePilot(input[1]);
                    break;
                case "Report":
                    message = machinesManager.pilotReport(input[1]);
                    break;
                case "ManufactureTank":
                    message = machinesManager.manufactureTank(input[1],Double.parseDouble(input[2]),Double.parseDouble(input[3]));
                    break;
                case "ManufactureFighter":
                    message = machinesManager.manufactureFighter(input[1],Double.parseDouble(input[2]),Double.parseDouble(input[3]));
                    break;
                case "Engage":
                    message = machinesManager.engageMachine(input[1],input[2]);
                    break;
                case "Attack":
                    message = machinesManager.attackMachines(input[1],input[2]);
                    break;
                case "AggressiveMode":
                    message = machinesManager.toggleFighterAggressiveMode(input[1]);
                    break;
                case "DefenseMode":
                    message = machinesManager.toggleTankDefenseMode(input[1]);
                    break;
            }
            System.out.println(message);
            input = scanner.nextLine().split("\\s+");
        }

    }
}
