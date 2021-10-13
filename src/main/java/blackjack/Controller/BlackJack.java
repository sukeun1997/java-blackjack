package blackjack.Controller;

import blackjack.Model.GameRunning;
import blackjack.Model.User.RequestUser;
import blackjack.Model.User.User;
import blackjack.Model.Users;
import blackjack.View.InputView;
import blackjack.View.OutputView;

import java.util.stream.Stream;

public class BlackJack {
    private static final String BET_MESSAGE = "의 배팅 금액은?";
    private static final String DELEAR_ADDCARD_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.";

    public static void run() {
        InputView.init();
    }

    public static void GameRunning(Users users)  {
        getPlayers(users).forEach(BlackJack::BetMoney);
        OutputView.cardDivide(users);
        ActionAddCard(users);
        GameResult(users);
    }

    private static void BetMoney(User user) {
        System.out.println(user.getName() + BET_MESSAGE);
        user.addMoney(InputView.answerMoney());
    }

    private static Stream<User> getPlayers(Users users) {
        return users.getUserList().stream().limit(users.getUserList().size() - 1);
    }
    private static void AnswerDealer(User user, RequestUser requestUser) {
        if (requestUser.isAddCard(user.getSum(), 17)) {
            System.out.println(DELEAR_ADDCARD_MESSAGE);
            user.addCard(user.getCardList());
        }
    }

    private static boolean CheckDelaer(User user) {
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
            AnswerPlayer(user, (a, b) -> a < 21);
        }
    }

    private static void ActionAddCard(Users users) {;
        // 플레이어
        for (User user : getPlayers(users).toList()) {
            AnswerPlayer(user, (a, b) -> a < 21);
        }

        // 딜러
        User delaer = users.getUserList().stream().filter(user -> user.isName("딜러")).findFirst().get();
        AnswerDealer(delaer, (a, b) -> a < 17);

        if (CheckDelaer(delaer)) {
            GameRunning.playerWin(users);
        }
    }
    //TODO
    private static void GameResult(Users users) {
        // 21이 초과시
        // users.getUserList().stream().filter(user -> user.getSum() > 21).forEach(user -> GameRunning.lose(user));

    }

}
