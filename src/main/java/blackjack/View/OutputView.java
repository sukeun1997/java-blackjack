package blackjack.View;

import blackjack.Model.User.User;
import blackjack.Model.Users;

public class OutputView {
    public static void cardDivide(Users users) {
        System.out.println("딜러와 " + users.getName() + "에게 2장을 나누었습니다.");
        ShowCard(users);
    }

    private static void ShowCard(Users users) {
        for (User user : users.getUserList()) {
            System.out.println(user.getName()+"카드: "+user.getCardList());
        }
    }
}
