package blackjack_feedback.model;

import blackjack_feedback.model.cardState.State;

import java.util.ArrayList;
import java.util.List;

public abstract class Player implements PlayerRule {

    private final String name;
    private State state;
    private ArrayList<Card> cardDeck = new ArrayList<>();
    private int betMoney;

    public Player(String person) {
        this.name = person;
        this.betMoney = 0;
        this.state = State.RUNNING;
    }

    @Override
    public List<Card> getCardList() {
        return this.cardDeck;
    }

    @Override
    public int totalScore() {

        int sum = cardDeck.stream().mapToInt(value -> value.getDenomination().getScore()).sum();

        if (cardDeck.stream().anyMatch(card -> card.getDenomination().isAce())) {
            sum = getAceScore(sum);
        }
        return sum;
    }

    private int getAceScore(int sum) {
        if (sum <= 11) {
            sum += 10;
        }
        return sum;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void addMoney(int betMoney) {
        this.betMoney += betMoney;
    }

    public int getBetMoney() {
        return this.betMoney;
    }
}