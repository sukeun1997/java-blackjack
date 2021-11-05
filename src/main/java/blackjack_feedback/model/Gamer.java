package blackjack_feedback.model;

import java.util.LinkedList;
import java.util.List;

public class Gamer implements  Player{

    private final String name;
    private final List<Card> cardDeck;

    private int betMoney;

    public Gamer(String person) {
        this.name = person;
        this.cardDeck = new LinkedList<>();
        this.betMoney = 0;
    }

    public void addMoney(int betMoney) {
        this.betMoney += betMoney;
    }

    public int getBetMoney() {
        return betMoney;
    }

    @Override
    public List<Card> getCardList() {
        return this.cardDeck;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
