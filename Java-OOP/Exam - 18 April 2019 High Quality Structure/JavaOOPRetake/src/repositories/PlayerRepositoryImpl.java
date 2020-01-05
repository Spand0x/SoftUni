package repositories;

import models.players.interfaces.Player;
import repositories.interfaces.PlayerRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayerRepositoryImpl implements PlayerRepository {
    private List<Player> players;

    public PlayerRepositoryImpl() {
        this.players = new ArrayList<>();
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public int getCount() {
        return this.players.size();
    }

    @Override
    public void add(Player player) {
        if(player == null){
            throw new IllegalArgumentException("Player cannot be null");
        }
        for (Player currentPlayer : players) {
            if (currentPlayer.getUsername().equals(player.getUsername())) {
                throw new IllegalArgumentException(String.format("Player %s already exists!",player.getUsername()));
            }
        }
        this.players.add(player);
    }

    @Override
    public boolean remove(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        return this.players.remove(player);
    }

    @Override
    public Player find(String name) {
        for (Player player : players) {
            if(player.getUsername().equals(name)){
                return player;
            }
        }
        return null;
    }
}
