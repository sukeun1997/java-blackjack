package blackjack_feedback.controller;

import blackjack_feedback.model.CardDeck;
import blackjack_feedback.model.Gamer;
import blackjack_feedback.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Running {

    static List<Gamer> gamerList = new ArrayList<>();


    public static void RunningGame() {

        CardDeck cardDeck = new CardDeck();

        // 플레이어 생성
        String[] gamers = InputView.createGamers();
        setGamers(gamers);

        // 플레이어 배팅
        setMoney(gamerList);


        // 카드 배팅

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
