package blackjack.Model;

import blackjack.Model.Card.Card;
import blackjack.Model.Card.CardList;
import blackjack.Model.Card.CardType;
import blackjack.Model.User.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CardTest {


    @ParameterizedTest
    @CsvSource(value = {"3,'D'","2,'H'", "8,'S'", "K,'S'", "A,'C'"})
    void 카드_생성(String num,String type) {
        Card card = new Card(num, CardType.valueOf(type));
        assertThat(card).isEqualTo(new Card(num, CardType.valueOf(type)));
    }

    @Test
    void 카드_랜덤_생성() {
        List<Card> cardList = new ArrayList<>();

        for (int i = 0; i <10 ; i++) {
            CardFactory.generateCard(cardList);
        }

        assertThat(cardList.size()).isEqualTo(2);
    }

}