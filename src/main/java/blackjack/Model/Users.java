package blackjack.Model;

import blackjack.Model.User.User;

import java.util.List;

public class Users {


    private final List<User> userList;

    public Users(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }
}
