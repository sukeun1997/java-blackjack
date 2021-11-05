package blackjack_feedback.model;

import java.util.LinkedList;
import java.util.List;

public class Dealer implements Player {

    private final List<Card> cardDeck;

    public Dealer() {
        cardDeck = new LinkedList<>();
    }

    @Override
    public List<Card> getCardList() {
        return cardDeck;
    }

    @Override
    public String getName() {
        return "딜러";
    }
}
