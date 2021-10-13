package blackjack.View;

import blackjack.Controller.BlackJack;
import blackjack.Model.CardFactory;
import blackjack.Model.GameRunning;
import blackjack.Model.User.RequestUser;
import blackjack.Model.User.User;
import blackjack.Model.Users;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.util.*;
import java.util.stream.Stream;

public class InputView {

    private static final String START_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)" ;
    private static final String CARD_ADD_MESSAGE = "는 한장의 카드를 더 받겠습니까 ? (예는 y, 아니오는 n)";

    static Scanner sc = new Scanner(System.in);

    public static void init() {
        System.out.println(START_MESSAGE);
        BlackJack.GameRunning(createUser(sc.nextLine()));
    }

    public static Users createUser(String name) {
        name += ",딜러";
        String[] names = name.trim().split(",");
        return createUser(names);
    }

    private static Users createUser(String[] names) {
        return new Users(Arrays.stream(names).map(user -> new User(user, 0, CardFactory.generateCard())).toList());
    }


    public static int answerMoney() {
        return sc.nextInt();
    }

    public static String answerAddCard(User user) {
        //TODO y,n 검증
        System.out.println(user.getName() + CARD_ADD_MESSAGE);
        return sc.next();
    }
}
