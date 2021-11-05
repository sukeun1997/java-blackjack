package blackjack_feedback.controller;

import blackjack_feedback.model.*;
import blackjack_feedback.view.InputView;
import blackjack_feedback.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Running {

    private static final int DRAW_COUNT = 2;
    static List<Gamer> gamerList = new ArrayList<>();


    public static void RunningGame() {

        // 카드덱 , 딜러 생성
        CardDeck cardDeck = new CardDeck();
        Dealer dealer = new Dealer();

        // 플레이어 생성
        String[] gamers = InputView.createGamers();
        setGamers(gamers);

        // 플레이어 배팅
        setMoney(gamerList);

        // 카드 분배
        DrawsPlayer(dealer,cardDeck);
    }

    private static void DrawsPlayer(Dealer dealer, CardDeck cardDeck) {

        for (Gamer gamer : gamerList) {
            drawCards(gamer, cardDeck);
        }
        drawCards(dealer, cardDeck);

        OutputView.showCardInfo(dealer, gamerList);
    }

    public static void drawCards(Player player, CardDeck cardDeck) {

        for (int i = 0; i < DRAW_COUNT; i++) {
            player.getCardList().add(cardDeck.draw());
        }
    }


    private static void setGamers(String[] gamersName) {

        for (String gamerName : gamersName) {
            Gamer gamer = new Gamer(gamerName);
            gamerList.add(gamer);
        }
    }

    private static void setMoney(List<Gamer> gamerList) {

        for (Gamer gamer : gamerList) {
            gamer.addMoney(InputView.betMoney(gamer.getName()));
        }
    }
}
