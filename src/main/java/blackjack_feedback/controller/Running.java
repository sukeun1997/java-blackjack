package blackjack_feedback.controller;

import blackjack_feedback.model.Gamer;
import blackjack_feedback.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Running {

    static List<Gamer> gamerList = new ArrayList<>();

    public static void RunningGame() {
        String[] gamers = InputView.createGamers();
        setGamers(gamers);
        setMoney(gamerList);
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
