package core;

import core.interfaces.ManagerController;
import models.battleFields.BattleFieldImpl;
import models.battleFields.interfaces.Battlefield;
import models.cards.MagicCard;
import models.cards.TrapCard;
import models.cards.interfaces.Card;
import models.players.Advanced;
import models.players.Beginner;
import models.players.interfaces.Player;
import repositories.CardRepositoryImpl;
import repositories.PlayerRepositoryImpl;
import repositories.interfaces.CardRepository;
import repositories.interfaces.PlayerRepository;

import static common.ConstantMessages.*;


public class ManagerControllerImpl implements ManagerController {
    private PlayerRepository playerRepository;
    private CardRepository cardRepository;
    private Battlefield battlefield;

    public ManagerControllerImpl() {
       this.playerRepository = new PlayerRepositoryImpl();
       this.cardRepository = new CardRepositoryImpl();
       this.battlefield = new BattleFieldImpl();
    }

    @Override
    public String addPlayer(String type, String username) {
        Player player = null;
        if(type.equals("Beginner")){
            player = new Beginner(new CardRepositoryImpl(),username);
        }else if (type.equals("Advanced")){
            player = new Advanced(new CardRepositoryImpl(),username);
        }
        this.playerRepository.add(player);
       return String.format(SUCCESSFULLY_ADDED_PLAYER,type,username);
    }

    @Override
    public String addCard(String type, String name) {
        Card card = null;
        if (type.equals("Magic")) {
            card = new MagicCard(name);
        } else if (type.equals("Trap")) {
            card = new TrapCard(name);
        }
        this.cardRepository.add(card);
        return String.format(SUCCESSFULLY_ADDED_CARD,type,name);
    }

    @Override
    public String addPlayerCard(String username, String cardName) {
        Player player = playerRepository.find(username);
        Card card = cardRepository.find(cardName);
        player.getCardRepository().add(card);
        return  String.format(SUCCESSFULLY_ADDED_PLAYER_WITH_CARDS,cardName,username);
    }

    @Override
    public String fight(String attackUser, String enemyUser) {
        Player attackPlayer = playerRepository.find(attackUser);
        Player enemyPlayer = playerRepository.find(enemyUser);
        battlefield.fight(attackPlayer,enemyPlayer);
        return  String.format(FIGHT_INFO,attackPlayer.getHealth(),enemyPlayer.getHealth());

    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Player player : this.playerRepository.getPlayers()) {
            sb.append(String.format(PLAYER_REPORT_INFO,player.getUsername(),player.getHealth(),player.getCardRepository().getCount())).append(System.lineSeparator());
            for (Card card : player.getCardRepository().getCards()) {
                sb.append(String.format(CARD_REPORT_INFO,card.getName(),card.getDamagePoints())).append(System.lineSeparator());
            }
            sb.append(DEFAULT_REPORT_SEPARATOR).append(System.lineSeparator());
        }
        return  sb.toString();
    }
}
