package blackjack.Model.Card;

import java.util.Objects;

public class Card {

    private final CardNumber number;

    private final CardType cardType;

    public Card(String num, CardType cardType) {
        this.number = new CardNumber(num);
        this.cardType = cardType;
    }

    public CardNumber getNumber() {
        return number;
    }

    public CardType getCardType() {
        return cardType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(number, card.number) && cardType == card.cardType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, cardType);
    }
}
