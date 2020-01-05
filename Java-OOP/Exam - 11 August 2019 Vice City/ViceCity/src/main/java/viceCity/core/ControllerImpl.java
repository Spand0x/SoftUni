package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.GunRepository;
import viceCity.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Collection<Player> civilPlayers;
    private Repository<Gun> gunRepository;
    private Neighbourhood neighbourhood;
    private Player mainPlayer;

    public ControllerImpl() {
        mainPlayer = new MainPlayer();
        civilPlayers = new LinkedList<>();
        gunRepository = new GunRepository();
        neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        this.civilPlayers.add(player);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun = null;
        if (type.equals("Pistol")) {
            gun = new Pistol(name);
        } else if (type.equals("Rifle")) {
            gun = new Rifle(name);
        } else {
            return GUN_TYPE_INVALID;
        }
        this.gunRepository.add(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (this.gunRepository.getModels().isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        }
        Gun gun = gunRepository.getModels().stream().findFirst().get();
        if (name.equals("Vercetti")) {
            this.mainPlayer.getGunRepository().add(gun);
            this.gunRepository.remove(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), mainPlayer.getName());
        }
        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.getName().equals(name)) {
                civilPlayer.getGunRepository().add(gun);
                this.gunRepository.remove(gun);
                return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), civilPlayer.getName());
            }
        }
        return CIVIL_PLAYER_DOES_NOT_EXIST;
    }

    @Override
    public String fight() {
        this.neighbourhood.action(mainPlayer, this.civilPlayers);
        boolean isHurt = false;

        if (mainPlayer.getLifePoints() != 100) {
            isHurt = true;
        } else {
            for (Player civilPlayer : civilPlayers) {
                if (civilPlayer.getLifePoints() != 50) {
                    isHurt = true;
                    break;
                }
            }
        }
        StringBuilder message = new StringBuilder();
        List<Player> civils = new LinkedList<>(this.civilPlayers);
        int countDead = 0;
        if (isHurt) {
            message.append(FIGHT_HAPPENED).append(System.lineSeparator());
            for (Player civil : civils) {
                if(!civil.isAlive()){
                    this.civilPlayers.remove(civil);
                    countDead++;
                }
            }
            message.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE,mainPlayer.getLifePoints())).append(System.lineSeparator());
            message.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE,countDead)).append(System.lineSeparator());
            message.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE,this.civilPlayers.size()));
        }else {
            message.append(FIGHT_HOT_HAPPENED);
        }
        return message.toString();
    }
}
