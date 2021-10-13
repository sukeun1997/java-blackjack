package blackjack.Model;

import blackjack.Model.Card.Card;
import blackjack.Model.Card.CardType;
import blackjack.Model.Card.Denomination;
import blackjack.Model.User.User;
import blackjack.View.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameRunningTest {

    Users users;


    Users SetCard(boolean both) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("pobi", 10000, Arrays.asList(new Card(Denomination.ACE, CardType.C), new Card(Denomination.QUEEN, CardType.C))));
        userList.add(new User("jack", 10000, Arrays.asList(new Card(Denomination.EIGHT, CardType.C), new Card(Denomination.QUEEN, CardType.C))));
        if(!both) {
            userList.add(new User("딜러", 10000, Arrays.asList(new Card(Denomination.EIGHT, CardType.C), new Card(Denomination.QUEEN, CardType.C))));
            return users = new Users(userList);
        }
        userList.add(new User("딜러", 10000, Arrays.asList(new Card(Denomination.ACE, CardType.C), new Card(Denomination.QUEEN, CardType.C))));
        return users = new Users(userList);
    }

    @Test
    void 유저만_2개합_블래잭() {
        SetCard(false);
        assertThat(GameRunning.blackJack(users)).isEqualTo(true);
        assertThat(users.getUsers().get(0).getMoney()).isEqualTo(15000);
    }

    @Test
    void 유저_딜러_모두_블랙잭() {
        SetCard(true);
        assertThat(GameRunning.blackJack(users)).isEqualTo(false);
        assertThat(users.getUsers().get(0).getMoney()).isEqualTo(10000);
    }
}