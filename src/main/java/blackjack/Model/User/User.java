package blackjack.Model.User;

import blackjack.Model.Card.Card;

import java.util.List;
import java.util.stream.Collectors;

public class User {

    private Name name;
    private Money money;
    private List<Card> cardList;

    public User(String name, int money, List<Card> cardList) {
        this.name = new Name(name);
        this.money = new Money(money);
        this.cardList = cardList;
    }


    public boolean isName(String username) {
        return name.getName().equals(username);
    }

    public Name getName() {
        return name;
    }

    public void addMoney(int money) {
        this.money = this.money.addMoney(money);
    }

    public int getMoney() {
        return this.money.getMoney();
    }

    public int getSum() {
        return this.cardList.stream().mapToInt(card -> card.getDenomination().getScore()).sum();
    }

    public String getCardList() {
        List<String> cardlist = cardList.stream().map(Card::toString).toList();
        return cardlist.stream().collect(Collectors.joining(","));
    }
}
