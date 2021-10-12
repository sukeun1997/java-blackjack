package blackjack.Model;

import blackjack.Model.Card.Card;
import blackjack.Model.Card.CardType;
import blackjack.Model.Card.Denomination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CardTest {

    static List<Card> cardList;
    @BeforeEach
    void setUp() {
        cardList = new ArrayList<>();
        for (int i = 0; i < 5 ; i++) {
            CardFactory.generateCard(cardList);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"THREE,'D'","TWO,'H'", "EIGHT,'S'", "KING,'S'", "ACE,'C'"})
    void 카드_생성(String num,String type) {
        Card card = new Card(Denomination.valueOf(num), CardType.valueOf(type));
        assertThat(card).isEqualTo(new Card(Denomination.valueOf(num), CardType.valueOf(type)));
    }

    @Test
    void 카드_랜덤_생성() {
        assertThat(cardList.size()).isEqualTo(5);
    }

    @Test
    void 카드_합_구하기() {
        System.out.println(cardList.stream().mapToInt(value -> value.getDenomination().getScore()).sum());
        assertThat(cardList.stream().mapToInt(value -> value.getDenomination().getScore()).sum()).isGreaterThanOrEqualTo(5);
    }


}