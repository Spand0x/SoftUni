package models.battleFields;

import models.battleFields.interfaces.Battlefield;
import models.cards.interfaces.Card;
import models.players.Beginner;
import models.players.interfaces.Player;

public class BattleFieldImpl implements Battlefield {

    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {
        if(attackPlayer.isDead() || enemyPlayer.isDead()){
            throw new IllegalArgumentException("Player is dead!");
        }

        isPlayerBeginner(attackPlayer);
        isPlayerBeginner(enemyPlayer);

        increaseBonus(attackPlayer);
        increaseBonus(enemyPlayer);


        int attackPlayerDamage = attackPlayer.getCardRepository().getCards().stream().mapToInt(Card::getDamagePoints).sum();
        int enemyPlayerDamage = enemyPlayer.getCardRepository().getCards().stream().mapToInt(Card::getDamagePoints).sum();
        while (!attackPlayer.isDead() && !enemyPlayer.isDead()){
            enemyPlayer.takeDamage(attackPlayerDamage);
            if(enemyPlayer.isDead()){
                return;
            }
            attackPlayer.takeDamage(enemyPlayerDamage);
            if(attackPlayer.isDead()){
                return;
            }
        }
    }

    private void increaseBonus(Player player) {
        int sum = player.getCardRepository().getCards().stream().mapToInt(Card::getHealthPoints).sum();
        player.setHealth(player.getHealth()+sum);
    }

    private void isPlayerBeginner(Player player) {
        if(player instanceof Beginner){
            player.setHealth(player.getHealth()+40);
            player.getCardRepository().getCards().forEach(card -> card.setDamagePoints(card.getDamagePoints()+30));
        }
    }
}
