package blackjack_feedback.controller;

import blackjack_feedback.model.*;
import blackjack_feedback.model.cardState.State;
import blackjack_feedback.view.InputView;
import blackjack_feedback.view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class Running {

    private static final int DRAW_COUNT = 2;
    public static final int MAX_SCORE = 21;
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

        // 카드 추가 분배
        addDrawCard(dealer,cardDeck);

        // 결과
        ResultBlackJack(dealer);
    }

    private static void ResultBlackJack(Dealer dealer) {

        OutputView.showResult(dealer);

        for (Gamer gamer : gamerList) {
            OutputView.showResult(gamer);
        }
    }

    private static void addDrawCard(Dealer dealer, CardDeck cardDeck) {

        for (Gamer gamer : gamerList) {
            GamerDraw(gamer,cardDeck);
        }

        DealerDraw(dealer, cardDeck);
    }

    public static void DealerDraw(Dealer dealer, CardDeck cardDeck) {
        System.out.println();
        if (dealer.totalScore() <= 16) {
            drawCards(dealer, cardDeck, 1);
            System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
        }

        if (dealer.totalScore() > 21) {
            dealer.setState(State.LOSE);
        }
    }

    private static void GamerDraw(Gamer gamer, CardDeck cardDeck) {
        if (isLose(gamer)) {
            return;
        }
        if(InputView.addDrawCardAnswer(gamer)) {
            drawCards(gamer,cardDeck,1);
            OutputView.showCardInfo(gamer);
            GamerDraw(gamer,cardDeck);
        }
    }

    private static void DrawsPlayer(Dealer dealer, CardDeck cardDeck) {

        System.out.println();

        for (Gamer gamer : gamerList) {
            drawCards(gamer, cardDeck, DRAW_COUNT);
            OutputView.showCardInfo(gamer);
        }
        drawCards(dealer, cardDeck,DRAW_COUNT);
        OutputView.showCardInfo(dealer);

    }

    public static void drawCards(Player player, CardDeck cardDeck, int count) {

        for (int i = 0; i < count; i++) {
            player.getCardList().add(cardDeck.draw());
        }
        if (player.totalScore() > MAX_SCORE) {
            player.setState(State.LOSE);
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

    private static boolean isLose(Gamer gamer) {
        return gamer.getState() == State.LOSE;
    }
}
