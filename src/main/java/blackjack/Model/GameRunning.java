package blackjack.Model;

import blackjack.Model.User.RequestUser;
import blackjack.Model.User.User;
import blackjack.View.InputView;
import blackjack.View.OutputView;

import java.util.stream.Stream;

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
}
