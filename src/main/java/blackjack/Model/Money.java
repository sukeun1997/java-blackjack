package blackjack.Model;

public class Money {

    private final int money;

    public Money(int money) {
        this.money = money;

    }

    public Money addMoney(int money) {
        return new Money(getMoney() + money);
    }

    public int getMoney() {
        return money;
    }
}
