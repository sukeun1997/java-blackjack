package blackjack_feedback.controller;

import blackjack_feedback.model.CardDeck;
import blackjack_feedback.model.Dealer;
import blackjack_feedback.model.Gamer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RunningTest {

    @Test
    @DisplayName("카드 분배 테스트")
    void cardDrawTest() {

        CardDeck cardDeck = new CardDeck();
        Gamer gamer = new Gamer("jake");
        Dealer dealer = new Dealer();


        Running.drawCards(gamer, cardDeck);
        Running.drawCards(dealer, cardDeck);

        assertThat(gamer.getCardList().size()).isEqualTo(2);

        System.out.println("플레이어");
        gamer.getCardList().stream().forEach(card -> System.out.println("card : "+ card.getDenomination() + " , " + card.getSuit()));
        System.out.println("딜러");
        dealer.getCardList().stream().forEach(card -> System.out.println("card : "+ card.getDenomination() + " , " + card.getSuit()));
        assertThat(dealer.getCardList().size()).isEqualTo(2);
    }
}