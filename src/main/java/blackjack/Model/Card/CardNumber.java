package blackjack.Model.Card;

import java.util.Objects;

public class CardNumber {

    private final String number;

    public CardNumber(String num) {
        this.number = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardNumber that = (CardNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
