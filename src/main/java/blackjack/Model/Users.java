package blackjack.Model;

import blackjack.Model.User.Name;
import blackjack.Model.User.User;

import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final List<User> userList;

    public Users(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public String getName() {
        List<String> userNames = userList.stream().limit(userList.size()-1).map(user -> user.getName().getName()).toList();
        String names = userNames.stream().collect(Collectors.joining(", "));
        return names;
    }
}
