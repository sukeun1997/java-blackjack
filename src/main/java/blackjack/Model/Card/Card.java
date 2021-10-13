package blackjack.Model.Card;

import java.util.Objects;

public class Card {


    private final CardType cardType;
    private final Denomination denomination;

    public Denomination getDenomination() {
        return denomination;
    }

    public Card(Denomination num, CardType cardType) {
        this.denomination = num;
        this.cardType = cardType;
    }

    private String getCardNumber() {
        if (isNumber()) {
            return String.valueOf(denomination.getScore());
        }
        return String.valueOf(denomination.name().charAt(0));
    }

    private boolean isNumber() {
        return denomination.getScore() < 10 || denomination.name().equals("TEN");
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


    @Override
    public String toString() {
        return getCardNumber()+cardType.getTypeName();
    }


}


