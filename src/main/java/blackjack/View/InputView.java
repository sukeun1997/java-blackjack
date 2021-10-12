package blackjack.View;

import blackjack.Model.User.User;
import blackjack.Model.Users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final String  START_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)" ;
    private static final String BET_MESSAGE = "의 배팅 금액은?";
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
        return new Users(Arrays.stream(names).map(user -> new User(user, 0, new ArrayList<>())).toList());
    }


    private static void Bet(Users users)  {
        for (User user : users.getUserList()) {
            BetMoney(user);
        }
    }

    private static void BetMoney(User user) {
        if(user.isName("딜러")) return;
        System.out.println(user.getName() + BET_MESSAGE);
        user.addMoney(sc.nextInt());
    }

}
