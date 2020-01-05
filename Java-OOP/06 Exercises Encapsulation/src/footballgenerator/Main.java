package footballgenerator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(";");
        Map<String,Team> teams = new LinkedHashMap<>();
        while (!"END".equalsIgnoreCase(input[0])){
            String command = input[0];
            String teamName = null;
            String playerName = null;

            switch (command){
                case "Team":
                    try {
                        Team team = new Team(input[1]);
                        teams.put(input[1],team);
                    }catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Add":
                    teamName = input[1];
                    playerName = input[2];
                    int endurance = Integer.parseInt(input[3]);
                    int sprint = Integer.parseInt(input[4]);
                    int dribble = Integer.parseInt(input[5]);
                    int passing = Integer.parseInt(input[6]);
                    int shooting  = Integer.parseInt(input[7]);
                    try{
                        if(teams.containsKey(teamName)){
                            Player player = new Player(playerName,endurance,sprint,dribble,passing,shooting);
                            teams.get(teamName).addPlayer(player);
                        }else {
                            System.out.println("Team " + teamName + " does not exist.");
                        }
                    }catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Remove":
                    teamName = input[1];
                    playerName = input[2];
                    try{
                        teams.get(teamName).removePlayer(playerName);
                    }catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Rating":
                    teamName = input[1];
                    if(teams.containsKey(teamName)){
                        int rating = (int) Math.round(teams.get(teamName).getRating());
                        System.out.println(teamName + " - " + rating);
                    }else {
                        System.out.println("Team " + teamName + " does not exist.");
                    }
                    break;
            }

            input = scanner.nextLine().split(";");
        }
    }
}
