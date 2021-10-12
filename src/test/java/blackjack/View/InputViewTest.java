package blackjack.View;

import blackjack.Model.User.User;
import blackjack.Model.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    Users users;
    @BeforeEach
    void setup() {
        String s = "pobi,jason";
        users = InputView.createUser(s);
    }

    @Test
    void User_생성() {
        assertThat(users.getUserList().size()).isEqualTo(3);
    }

    @Test
    void User_배팅금액_설정() {
        int money = 10000;
        User pobi = users.getUserList().stream().filter(user -> user.isName("pobi")).findAny().get();
        pobi.addMoney(money);
        assertThat(pobi.getMoney()).isEqualTo(10000);
    }
}