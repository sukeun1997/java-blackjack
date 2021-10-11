package blackjack.Model.User;

import blackjack.Model.Card.Card;

import java.util.List;

public class User {
    private Name name;
    private Money money;
    private List<Card> card;

    public User(String name, int money, List<Card> cardList) {
        this.name = new Name(name);
        this.money = new Money(money);
        this.card = cardList;
    }

    public boolean getName(String username) {
        return name.getName().equals(username);
    }

    public void addMoney(int money) {
        this.money = this.money.addMoney(money);
    }

    public int getMoney() {
        return this.money.getMoney();
    }
}
