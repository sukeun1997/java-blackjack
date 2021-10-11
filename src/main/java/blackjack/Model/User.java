package blackjack.Model;

import java.util.List;

public class User {
    private final String name;
    private final int money;
    private final List<Card> card;

    public User(String name, int money, List<Card> cardList) {
        this.name = name;
        this.money = money;
        this.card = cardList;
    }
}
