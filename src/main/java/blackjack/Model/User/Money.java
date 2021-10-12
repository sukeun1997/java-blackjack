package blackjack.Model.User;

public class Money {

    private final int money;

    public Money(int money) {
        this.money = money;

    }

    public Money addMoney(int money) {
        CheckNegative(money);
        return new Money(getMoney() + money);
    }

    private void CheckNegative(int money) {
        if (money < 0 && money > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("옳바른 배팅 금액이 아닙니다. : " + money);
        }
    }

    public int getMoney() {
        return money;
    }
}
