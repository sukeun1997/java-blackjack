package blackjack.Model.Card;

public enum CardType {
    S(1),
    D(2),
    H(3),
    C(4),
    ;

    public int getType() {
        return type;
    }

    private final int type;

    CardType(int type) {
        this.type = type;
    }
}
