package blackjack.Model.User;

import java.util.Objects;

public class Name {


    private final String name;

    public Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
