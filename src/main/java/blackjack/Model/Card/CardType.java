package blackjack.Model.Card;

public enum CardType {
    S("스페이드"),D("다이아몬드"),H("하트"),C("클로버");

    private final String TypeName;

    CardType(String TypeName) {
        this.TypeName = TypeName;
    }

    public String getTypeName() {
        return TypeName;
    }
}
