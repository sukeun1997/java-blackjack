package blackjack_feedback.view;

import blackjack_feedback.model.Card;
import blackjack_feedback.model.Dealer;
import blackjack_feedback.model.Gamer;
import blackjack_feedback.model.Player;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.List;

public class OutputView {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void showCardInfo(Dealer dealer, List<Gamer> gamerList) {

        System.out.print(dealer.getName() +": ");
        showHaveCardList(dealer);


        for (Gamer gamer : gamerList) {
            System.out.println(gamer.getName() +": ");
            showHaveCardList(gamer);
        }
    }

    private static void showHaveCardList(Player player) {
        for (Card card : player.getCardList()) {
            System.out.print(card.getDenomination().getScore() + card.getSuit().getName() + " ");
        }
        System.out.println();
    }
}
