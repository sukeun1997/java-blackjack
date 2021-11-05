package blackjack_feedback.model;

import blackjack_feedback.model.cardState.State;

import java.util.ArrayList;
import java.util.List;

public class Gamer implements  Player{

    private final String name;
    private State state;
    private ArrayList<Card> cardDeck = new ArrayList<>();

    private int betMoney;

    public Gamer(String person) {
        this.name = person;
        this.betMoney = 0;
        this.state = State.RUNNING;
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

    @Override
    public int totalScore() {
        return cardDeck.stream().mapToInt(value -> value.getDenomination().getScore()).sum();
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }
}
