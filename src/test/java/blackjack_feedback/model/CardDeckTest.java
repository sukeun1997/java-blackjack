package blackjack_feedback.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CardDeckTest {

    @Test
    @DisplayName("카드덱 갯수 테스트")
    void cardDeckTest() {
        CardDeck cardDeck = new CardDeck();
        assertThat(cardDeck.getCards().size()).isEqualTo(52);
        cardDeck.getCards().stream().forEach(card -> System.out.println("숫자 : " + card.getDenomination() + "무늬 " + card.getSuit()));
    }
}