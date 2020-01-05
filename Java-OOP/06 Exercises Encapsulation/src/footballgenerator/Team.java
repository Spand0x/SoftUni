package footballgenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }
    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void removePlayer(String playerName){
        boolean contains = false;
        for (Player player :
                players) {
            if (player.getName().equals(playerName)){
                players.remove(player);
                contains = true;
                break;
            }
        }
        if(!contains){
            throw new IllegalArgumentException("Player " + playerName + " is not in " + this.name + " team.");
        }
    }

    public double getRating(){
        double sum = players.stream().mapToDouble(Player::overallSkillLevel).sum();
        return sum/players.size();
    }

    private void setName(String name){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

}
