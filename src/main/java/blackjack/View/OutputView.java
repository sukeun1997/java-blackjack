package blackjack.View;

import blackjack.Model.User.User;
import blackjack.Model.Users;

public class OutputView {
    private static final String LOSE_MESSAGE = "카드의 합이 21을 초과하여 패배 하셨습니다.";
    private static final String END_MESSAGE = "## 최종 수익";

    public static void cardDivide(Users users) {
        System.out.println("딜러와 " + users.getName() + "에게 2장을 나누었습니다.");
        users.getUserList().stream().forEach(user -> ShowCard(user));
    }

    public static void ShowCard(User user) {
            System.out.println(user.getName()+"카드: "+user.getCardListInfo());
    }

    public static void gameEnd(Users users) {
        System.out.println(END_MESSAGE);
        users.getUserList().stream().forEach(System.out::println);
    }
}
