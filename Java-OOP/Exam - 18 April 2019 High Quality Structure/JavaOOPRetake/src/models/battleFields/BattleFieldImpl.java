package models.battleFields;

import models.battleFields.interfaces.Battlefield;
import models.players.Beginner;
import models.players.interfaces.Player;

import java.util.stream.IntStream;

public class BattleFieldImpl implements Battlefield {


    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {
        isPlayerDead(attackPlayer);
        isPlayerDead(enemyPlayer);

        isPlayerBeginner(attackPlayer);
        isPlayerBeginner(enemyPlayer);

        bonusHealthPoints(attackPlayer);
        bonusHealthPoints(enemyPlayer);

        while (!attackPlayer.isDead() && !enemyPlayer.isDead()) {
            attack(attackPlayer,enemyPlayer);
            if(enemyPlayer.isDead()){
                break;
            }
            attack(enemyPlayer,attackPlayer);
        }
    }

    private void attack(Player attacker, Player enemy) {
        int damage = attacker.getCardRepository().getCards().stream().flatMapToInt(card -> IntStream.of(card.getDamagePoints())).sum();
        enemy.takeDamage(damage);
    }

    private void bonusHealthPoints(Player player) {
        int sum = player.getCardRepository().getCards().stream().flatMapToInt(card -> IntStream.of(card.getHealthPoints())).sum();
        player.setHealth(player.getHealth()+sum);
    }

    private void isPlayerBeginner(Player player) {
        if(player instanceof Beginner){
            player.setHealth(player.getHealth()+40);
            player.getCardRepository().getCards().forEach(card -> card.setDamagePoints(card.getDamagePoints()+30));
        }
    }

    private void isPlayerDead(Player player) {
        if(player.isDead()){
            throw new IllegalArgumentException("Player is dead!");
        }
    }

}
