package blackjack_feedback.model;

import blackjack_feedback.model.cardState.State;

import java.util.List;

public interface Player {

    List<Card> getCardList();

    String getName();

    int totalScore();

    State getState();

    void setState(State state);
}