package repositories;

import models.cards.interfaces.Card;
import repositories.interfaces.CardRepository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CardRepositoryImpl implements CardRepository {
    private List<Card> cards;

    public CardRepositoryImpl() {
        this.cards = new LinkedList<>();
    }

    @Override
    public int getCount() {
        return this.cards.size();
    }

    @Override
    public List<Card> getCards() {
        return Collections.unmodifiableList(this.cards);
    }

    @Override
    public void add(Card card) {
        if (card == null){
            throw new IllegalArgumentException("Card cannot be null!");
        }
        for (Card currentCard : cards) {
            if(currentCard.getName().equals(card.getName())){
                throw new IllegalArgumentException(String.format("Card %s already exists!",card.getName()));
            }
        }
        this.cards.add(card);
    }

    @Override
    public boolean remove(Card card) {
        if(card == null){
            throw new IllegalArgumentException("Card cannot be null!");
        }
        return this.cards.remove(card);
    }

    @Override
    public Card find(String name) {
        return this.cards.stream().filter(card -> card.getName().equals(name)).findFirst().get();
    }
}
