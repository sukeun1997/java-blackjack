package blackjack_feedback.view;

import blackjack_feedback.model.Dealer;
import blackjack_feedback.model.Gamer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    List<Gamer> gamerList = new ArrayList<>();

    @Test
    void 플레이어_딜러_생성() {
        String people[] = "pobi,jason".split(",");

        List<Gamer> gamers = new ArrayList<>();
        for (String person : people) {
            Gamer gamer = new Gamer(person);
            gamers.add(gamer);
        }
        Dealer dealer = new Dealer();

        assertThat(gamers.size()).isEqualTo(2);
        assertThat(dealer).isNotNull();

    }


    public List<Gamer> createGamer(String gamer) {
            Gamer gamers = new Gamer(gamer);
            gamerList.add(gamers);
        return gamerList;
    }


    @Test
    void 플레이어이름_유효성_검사() {

        String s = "json,sim.son";
        Pattern pattern = Pattern.compile("([a-zA-Z]*)(,([a-zA-Z]+))*");
        Matcher matcher = pattern.matcher(s.trim());

        if(matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    @DisplayName("배팅머니 테스트")
    void betMoney() {
        createGamer("json,sim");

        for (Gamer gamer : gamerList) {
            gamer.addMoney(InputView.betMoney(10000));
            assertThat(gamer.getBetMoney()).isEqualTo(10000);
        }
    }
}