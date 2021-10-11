package blackjack.View;

import blackjack.Model.User;
import blackjack.Model.Users;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void User_생성() {

        String s = "pobi,jason";
        Users users = InputView.createUser(s);
        assertThat(users.getUserList().size()).isEqualTo(3);
    }
}