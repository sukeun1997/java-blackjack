package blackjack.Controller;

import blackjack.Model.GameRunning;
import blackjack.Model.User.RequestUser;
import blackjack.Model.User.User;
import blackjack.Model.Users;
import blackjack.View.InputView;
import blackjack.View.OutputView;

public class BlackJack {
    private static final String BET_MESSAGE = "의 배팅 금액은?";
    private static final String DELEAR_ADDCARD_MESSAGE = "\n딜러는 16이하라 한장의 카드를 더 받았습니다.\n";

    public static void run() {
        InputView.init();
    }

    public static void GameRunning(Users users)  {
        // 배팅
        users.getUsers().forEach(BlackJack::BetMoney);

        // 카드 분배 완료
        OutputView.cardDivide(users);


        // 2개 합 블랙잭
        if(!GameRunning.blackJack(users))
            // 추가 카드 분배
            ActionAddCard(users);

        // 배팅금액 분배
        GameRunning.DivdeBetMoney(users);


        if (CheckDelaerSum(users.getDealer())) {
            GameRunning.playerWin(users);
            return;
        }
        // 게임 결과
        GameResult(users);
    }

    private static void BetMoney(User user) {
        System.out.println(user.getName() + BET_MESSAGE);
        user.addMoney(InputView.answerMoney());
    }

    private static void AnswerDealer(User user, RequestUser requestUser) {
        if (requestUser.isAddCard(user.getSum(), 17)) {
            System.out.println(DELEAR_ADDCARD_MESSAGE);
            user.addCard(user.getCardList());
        }
    }

    private static boolean CheckDelaerSum(User user) {
        return user.getSum() > 21;
    }

    private static void AnswerPlayer(User user, RequestUser requestUser) {
        if (requestUser.isAddCard(user.getSum(), 21)) {
            String answer = InputView.answerAddCard(user);
            if (answer.equalsIgnoreCase("n")) {
                return;
            }
            AddCardPlayer(user, answer);
            return;
        }

        GameRunning.lose(user);
    }

    private static void AddCardPlayer(User user, String answer) {
        if (answer.equalsIgnoreCase("y")) {
            user.addCard(user.getCardList());
            OutputView.ShowCard(user);
            AnswerPlayer(user, (a, b) -> a <= 21);
        }
    }

    private static void ActionAddCard(Users users) {;
        // 플레이어
        for (User user : users.getUsers()) {
            AnswerPlayer(user, (a, b) -> a <= 21);
        }

        // 딜러
        User dealer = users.getDealer();
        AnswerDealer(dealer, (a, b) -> a < 17);
    }
    //TODO
    private static void GameResult(Users users) {
        OutputView.showResult(users);
        OutputView.gameEnd(users);
    }

}
