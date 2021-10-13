package blackjack.Model;

import blackjack.Model.User.User;
import blackjack.View.OutputView;

import java.util.Comparator;

public class GameRunning  {

    public static void lose(User user) {
        // 플레이어 21 초과
        user.addMoney(-user.getMoney()*2);
    }

    public static void playerWin(Users users) {
        // 플레이어 패의 합이 21 이 넘었을떄 초기화
        users.getUserList().stream().filter(user -> user.getMoney() < 0).forEach(user -> user.addMoney(Math.abs(user.getMoney()*2)));
        OutputView.showResult(users);
        OutputView.gameEnd(users);
    }

    //2개합 블랙잭
    public static boolean blackJack(Users users) {
        User dealer = users.getDealer();
        if (isBlackJack(dealer)) {
            return false;
        }
        if(users.getUsers().stream().anyMatch(GameRunning::isBlackJack)) {
            users.getUsers().stream().filter(GameRunning::isBlackJack).forEach(user -> user.addMoney(user.getMoney() / 2));
            return true;
        }
        return false;
    }

    public static boolean isBlackJack(User user) {
        return user.getSum() == 21;
    }

    public static void DivdeBetMoney(Users users) {
        User user = users.getUserList().stream().filter(user1 -> user1.getSum() <= 21).max(Comparator.comparingInt(User::getSum)).get();
        user.addMoney(user.getMoney() / 2);

        users.getUsers().stream().filter(user1 -> user1 != user).filter(user1 -> user1.getMoney() > 0).forEach(user1 -> user1.addMoney(-user1.getMoney()*2));
    }
}
