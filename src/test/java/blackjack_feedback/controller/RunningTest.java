package blackjack_feedback.controller;

import blackjack_feedback.model.Card;
import blackjack_feedback.model.CardDeck;
import blackjack_feedback.model.Dealer;
import blackjack_feedback.model.Gamer;
import blackjack_feedback.model.cardState.State;
import blackjack_feedback.model.constant.Denomination;
import blackjack_feedback.model.constant.Suit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RunningTest {

    CardDeck cardDeck;
    Gamer gamer;
    Dealer dealer;

    public void DrawCard() {
        cardDeck = new CardDeck();
        gamer = new Gamer("jake");
        dealer = new Dealer();
        Running.drawCards(gamer, cardDeck,2);
        Running.drawCards(dealer, cardDeck,2);
    }

    @Test
    @DisplayName("카드 분배 테스트")
    void cardDrawTest() {

        cardDeck = new CardDeck();
        gamer = new Gamer("jake");
        dealer = new Dealer();
        Running.drawCards(gamer, cardDeck,2);
        Running.drawCards(dealer, cardDeck,2);

        assertThat(gamer.getCardList().size()).isEqualTo(2);

        System.out.println("플레이어");
        showCardInfo(gamer.getCardList());
        System.out.println("딜러");
        showCardInfo(dealer.getCardList());
        assertThat(dealer.getCardList().size()).isEqualTo(2);
    }

    private void showCardInfo(List<Card> cardList) {
        cardList.stream().forEach(card -> System.out.println("card : " + card.getDenomination() + " , " + card.getSuit()));
    }

    @Test
    @DisplayName("카드 추가분배 합 21 초과 테스트")
    void addDrawGamerTest() {
        DrawCard();
        while (gamer.totalScore() <= 21) {
            Running.drawCards(gamer,cardDeck,1);
        }

        assertThat(gamer.getState()).isEqualTo(State.LOSE);
    }

    @Test
    @DisplayName("딜러 카드 분배 21 초과 테스트")
    void addDrawDealerTest() {
        DrawCard();

        while (dealer.totalScore() <= 21) {
            Running.DealerDraw(dealer,cardDeck);
        }

        assertThat(dealer.getState()).isEqualTo(State.LOSE);
    }

    @Test
    @DisplayName("ACE 점수 테스트")
    void AceScoretest() {
        DrawCard();
        gamer.getCardList().add(new Card(Denomination.ACE, Suit.SPADES));

        showCardInfo(gamer.getCardList());
        System.out.println(gamer.totalScore());

    }
}