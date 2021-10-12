package blackjack.View;

import blackjack.Model.CardFactory;
import blackjack.Model.GameRunning;
import blackjack.Model.User.RequestUser;
import blackjack.Model.User.User;
import blackjack.Model.Users;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final String  START_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)" ;
    private static final String BET_MESSAGE = "의 배팅 금액은?";
    private static final String CARD_ADD_MESSAGE = "는 항장의 카드를 더 받겠습니까 ? (예는 y, 아니오는 n)";
    static Scanner sc = new Scanner(System.in);

    public static void init() {
        System.out.println(START_MESSAGE);
        Bet(createUser(sc.nextLine()));
    }


    public static Users createUser(String name) {
        name += ",딜러";
        String[] names = name.trim().split(",");
        return createUser(names);
    }

    private static Users createUser(String[] names) {
        return new Users(Arrays.stream(names).map(user -> new User(user, 0, CardFactory.generateCard())).toList());
    }

    private static void BetMoney(User user) {
        System.out.println(user.getName() + BET_MESSAGE);
        user.addMoney(sc.nextInt());
    }
    private static Stream<User> getPlayers(Users users) {
        return users.getUserList().stream().limit(users.getUserList().size() - 1);
    }
    public static void Bet(Users users)  {
        getPlayers(users).forEach(InputView::BetMoney);
        OutputView.cardDivide(users);
        ActionAddCard(users);
        CheckCardSum(users);
    }

    private static void CheckCardSum(Users users) {

    }

    private static void AnswerDealer(User user, RequestUser requestUser) {
        if (requestUser.isAddCard(user.getSum(), 17)) {
            user.addCard(user.getCardList());
        }
        return; // 21 넘어감
    }

    private static void AnswerPlayer(User user, RequestUser requestUser) {
        if (requestUser.isAddCard(user.getSum(), 21)) {
            System.out.println(user.getName() + CARD_ADD_MESSAGE);
            String answer = sc.next();
            if (answer.equalsIgnoreCase("n")) {
                return;
            }
            AddCardPlayer(user, answer);
        }
        return; // 21 넘어감
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

    }

}
