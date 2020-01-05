package militaryelite;

import militaryelite.common.MissionImpl;
import militaryelite.common.RepairImpl;
import militaryelite.enums.Corp;
import militaryelite.enums.State;
import militaryelite.interfaces.*;
import militaryelite.models.*;

import java.util.*;
import java.util.stream.Collectors;


public class Main {

    private static List<Soldier> army =  new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        while (!"End".equals(input[0])) {
            Soldier soldier = null;
            String command =  input[0];
            List<String> tokens = Arrays.stream(input).skip(1).collect(Collectors.toList());
            int id = Integer.parseInt(tokens.get(0));
            String firstName = tokens.get(1);
            String lastName = tokens.get(2);
            double salary = Double.parseDouble(tokens.get(3));

            if (command.equals("Private")) {
                soldier = new PrivateImpl(id, firstName, lastName, salary);
            } else if (command.equals("LeutenantGeneral")) {
                soldier = new LeutenantGeneralImpl(id, firstName, lastName, salary);
                int[] ids = tokens.stream().skip(4).mapToInt(Integer::parseInt).toArray();
                for (int currentId : ids) {
                    for (Soldier currentSoldier : army) {
                        if (currentSoldier instanceof Private && currentSoldier.getId() == currentId) {
                            ((LeutenantGeneralImpl) soldier).addPrivate((Private) currentSoldier);
                        }
                    }
                }
            } else if (command.equals("Engineer")) {
                String corps = tokens.get(4);
                if (Corp.Airforces.toString().equals(corps) || Corp.Marines.toString().equals(corps)) {
                    soldier = new EngineerImpl(id, firstName, lastName, salary, Corp.valueOf(corps));
                    String[] repairData = tokens.stream().skip(5).toArray(String[]::new);
                    for (int i = 0; i < repairData.length; i += 2) {//maybe <=
                        RepairImpl repair = new RepairImpl(repairData[i], Integer.parseInt(repairData[i + 1]));
                        ((EngineerImpl) soldier).addRepair(repair);

                    }
                }

            } else if (command.equals("Commando")) {
                String corps = tokens.get(4);
                if (Corp.Airforces.toString().equals(corps) || Corp.Marines.toString().equals(corps)) {
                    soldier = new CommandoImpl(id, firstName, lastName, salary, Corp.valueOf(corps));
                    String[] missionData = tokens.stream().skip(5).toArray(String[]::new);
                    for (int i = 0; i < missionData.length; i += 2) {//maybe <=
                        if(State.Finished.toString().equals(missionData[i+1]) || State.inProgress.toString().equals(missionData[i+1])){
                            MissionImpl mission = new MissionImpl(missionData[i],State.valueOf(missionData[i+1]));
                            ((CommandoImpl) soldier).addMission(mission);
                        }
                    }
                }
            } else if (command.equals("Spy")) {
                soldier = new SpyImpl(id,firstName,lastName,tokens.get(3));
            }

            if (soldier != null) {
                army.add(soldier);
            }
            input = scanner.nextLine().split("\\s+");
        }
        for (Soldier soldier : army) {
            System.out.println(soldier.toString());
        }
    }
}
