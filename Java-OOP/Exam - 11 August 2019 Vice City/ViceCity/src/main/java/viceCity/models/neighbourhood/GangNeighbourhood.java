package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {


    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        //todo: Double Check
        for (Gun gun : mainPlayer.getGunRepository().getModels()) {
            for (Player civilPlayer : civilPlayers) {
               while (civilPlayer.isAlive() && gun.canFire()){
                   civilPlayer.takeLifePoints(gun.fire());
               }
               if(!gun.canFire()){
                   break;
               }
            }
        }

        for (Player civilPlayer : civilPlayers) {
            for (Gun gun : civilPlayer.getGunRepository().getModels()) {
                while (mainPlayer.isAlive() && gun.canFire()){
                    mainPlayer.takeLifePoints(gun.fire());
                }
                if(!gun.canFire()){
                    break;
                }
                if(!mainPlayer.isAlive()){
                    return;
                }
            }
        }
    }
}
