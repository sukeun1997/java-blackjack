package blackjack_feedback.model;

import blackjack_feedback.model.constant.Denomination;
import blackjack_feedback.model.constant.Suit;

public class Card {

    private final Denomination denomination;

    private final Suit suit;

    public Card(Denomination denomination, Suit suit) {
        this.denomination = denomination;
        this.suit = suit;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public Suit getSuit() {
        return suit;
    }


}
