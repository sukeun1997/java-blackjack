package blackjack.Model.Card;

import java.util.Objects;

public class Card {


    private final CardType cardType;

    private final Denomination denomination;

    public Card(Denomination num, CardType cardType) {
        this.denomination = num;
        this.cardType = cardType;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public CardType getCardType() {
        return cardType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardType == card.cardType && denomination == card.denomination;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardType, denomination);
    }
}
