package blackjack_feedback.model;

import blackjack_feedback.model.constant.Denomination;
import blackjack_feedback.model.constant.Suit;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class CardDeck {

    private Stack<Card> cards;

    public CardDeck() {
        this.cards = new Stack<>();

        for (Denomination value : Denomination.values()) {
            for (Suit suit : Suit.values()) {
                Card card = new Card(value, suit);
                cards.push(card);
            }
        }
    }

    public Stack<Card> getCards() {
        return cards;
    }




}
