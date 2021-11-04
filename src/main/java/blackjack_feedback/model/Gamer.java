package blackjack_feedback.model;

import java.util.LinkedList;
import java.util.List;

public class Gamer {

    private final String name;
    private final List<Card> cardDeck;

    public Gamer(String person) {
        this.name = person;
        this.cardDeck = new LinkedList<>();
    }

}
