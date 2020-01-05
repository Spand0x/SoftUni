package models.players;

import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;

public abstract class BasePlayer implements Player {
    private CardRepository cardRepository;
    private String username;
    private int health;
    private boolean isDead;

    public BasePlayer(CardRepository cardRepository, String username, int health) {
        this.cardRepository = cardRepository;
        setUsername(username);
        setHealth(health);
        isDead = false;
    }

    public void setUsername(String username) {
        if(username == null || username.trim().isEmpty()){
            throw new IllegalArgumentException("Player's username cannot be null or an empty string.");
        }
        this.username = username;
    }

    @Override
    public void setHealth(int health) {
        if(health<0){
            throw new IllegalArgumentException("Player's health bonus cannot be less than zero.");
        }
        this.health = health;
    }

    @Override
    public void takeDamage(int damagePoints) {
        if(damagePoints<0){
            throw new IllegalArgumentException("Damage points cannot be less than zero.");
        }
        this.health-=damagePoints;
        if(this.health<0){
            this.health = 0;
            this.isDead = true;
        }
    }

    @Override
    public CardRepository getCardRepository() {
        return cardRepository;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public boolean isDead() {
        return isDead;
    }
}
