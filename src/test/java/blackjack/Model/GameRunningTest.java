package blackjack.Model;

import blackjack.Model.Card.Card;
import blackjack.Model.Card.CardType;
import blackjack.Model.Card.Denomination;
import blackjack.Model.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameRunningTest {

    Users users;


    @Test
    void 유저만_2개합_블래잭() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("pobi", 10000, Arrays.asList(new Card(Denomination.ACE, CardType.C), new Card(Denomination.QUEEN, CardType.C))));
        userList.add(new User("jack", 10000, Arrays.asList(new Card(Denomination.EIGHT, CardType.C), new Card(Denomination.QUEEN, CardType.C))));
        userList.add(new User("딜러", 10000, Arrays.asList(new Card(Denomination.EIGHT, CardType.C), new Card(Denomination.QUEEN, CardType.C))));
        users = new Users(userList);
        assertThat(GameRunning.blackJack(users)).isEqualTo(true);
        assertThat(userList.get(0).getMoney()).isEqualTo(15000);
    }

    @Test
    void 유저_딜러_모두_블랙잭() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("pobi", 10000, Arrays.asList(new Card(Denomination.ACE, CardType.C), new Card(Denomination.QUEEN, CardType.C))));
        userList.add(new User("jack", 10000, Arrays.asList(new Card(Denomination.EIGHT, CardType.C), new Card(Denomination.QUEEN, CardType.C))));
        userList.add(new User("딜러", 10000, Arrays.asList(new Card(Denomination.ACE, CardType.C), new Card(Denomination.QUEEN, CardType.C))));
        users = new Users(userList);
        assertThat(GameRunning.blackJack(users)).isEqualTo(false);
        assertThat(userList.get(0).getMoney()).isEqualTo(10000);
    }
}