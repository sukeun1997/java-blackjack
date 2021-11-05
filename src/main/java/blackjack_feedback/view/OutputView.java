package blackjack_feedback.view;

import blackjack_feedback.model.Card;
import blackjack_feedback.model.Dealer;
import blackjack_feedback.model.Gamer;
import blackjack_feedback.model.Player;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.List;

public class OutputView {

    public static void showCardInfo(Player player) {
        System.out.print(player.getName() +": ");
        showHaveCardList(player);
        System.out.println();
    }

    private static void showHaveCardList(Player player) {
        for (Card card : player.getCardList()) {
            System.out.print(card.getDenomination().getScore() + card.getSuit().getName() + " ");
        }
    }

    public static void showResult(Player player) {

        System.out.print(player.getName() +" 카드:");
        showHaveCardList(player);
        System.out.print("- 결과:" + player.totalScore());
        System.out.println();
    }
}
