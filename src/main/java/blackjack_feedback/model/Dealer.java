package blackjack_feedback.model;

import blackjack_feedback.model.cardState.State;

import java.util.LinkedList;
import java.util.List;

public class Dealer implements Player {

    private final List<Card> cardDeck;
    private State state;

    public Dealer() {
        cardDeck = new LinkedList<>();
        state = State.RUNNING;
    }

    @Override
    public List<Card> getCardList() {
        return cardDeck;
    }

    @Override
    public String getName() {
        return "딜러";
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
