package blackjack.View;

import blackjack.Controller.BlackJack;
import blackjack.Model.CardFactory;
import blackjack.Model.User.User;
import blackjack.Model.Users;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private static final String START_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)" ;
    private static final String CARD_ADD_MESSAGE = "는 한장의 카드를 더 받겠습니까 ? (예는 y, 아니오는 n)";
    private static final String INPUT_ERROR_MESSAGE = "y 또는 n 만 입력할 수 있습니다.";
    private static final String EXCEPT_NAME_MESSAGE = "딜러 라는 이름은 사용할 수 없습니다.";
    private static final String NAME_ERROR_MESSAGE = "옳바른 이름을 입력 해 주세요";
    private static final String ERROR_MONEY_INPUT_MESSAGE = "옳바른 배팅 금액을 입력 해 주세요";

    static Scanner sc = new Scanner(System.in);

    public static void init() {
        System.out.println(START_MESSAGE);
        String name = Optional.ofNullable(sc.nextLine()).orElseThrow(() -> new IllegalArgumentException(NAME_ERROR_MESSAGE));
        BlackJack.GameRunning(createUser(name));
    }

    public static Users createUser(String name) {
        CheckName(name);
        name += ",딜러";
        String[] names = name.trim().split(",");
        return createUser(names);
    }

    private static void CheckName(String name) {
        if (name.contains("딜러")) {
            throw new IllegalArgumentException(EXCEPT_NAME_MESSAGE);
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
        }
    }

    private static Users createUser(String[] names) {
        return new Users(Arrays.stream(names).map(user -> new User(user, 0, CardFactory.generateCard())).toList());
    }


    public static int answerMoney() {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(sc.next());
        if (!matcher.find()) {
            throw new IllegalArgumentException(ERROR_MONEY_INPUT_MESSAGE);
        }
        return Integer.parseInt(matcher.group());
    }

    public static String answerAddCard(User user) {
        System.out.println(user.getName() + CARD_ADD_MESSAGE);
        return CheckAnswer(sc.next());
    }

    private static String CheckAnswer(String answer) {
        if(!answer.matches("[Yy]|[Nn]"))
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        return answer;
    }
}
