package blackjack.View;

import blackjack.Model.User;
import blackjack.Model.Users;

import java.util.ArrayList;
import java.util.Arrays;

public class InputView {
    public static Users createUser(String name) {
        name += ",딜러";
        String[] names = name.trim().split(",");
        return createUser(names);
    }

    private static Users createUser(String[] names) {
        return new Users(Arrays.stream(names).map(user -> new User(user, 0, new ArrayList<>())).toList());
    }
}
