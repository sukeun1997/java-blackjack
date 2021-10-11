package blackjack.Model;

import blackjack.Model.Card.Card;
import blackjack.Model.Card.CardType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CardFactory {
    static String[] CARD_LIST = {"k","q","j","a"};
    static String[] CARD_TYPE_LIST = {"S", "D", "H", "C"};

    public static List<Card> generateCard(List<Card> cardList) {
        int RandomNumber = (int) (Math.random() * 13 + 1);
        int RandomType = (int) (Math.random() * 3 + 1);
        cardList.add(new Card(ChoiceCardNumber(RandomNumber), CardType.valueOf(CARD_TYPE_LIST[RandomType])));
        return cardList;
    }

    private static String ChoiceCardNumber(int Random) {
        if (Random >= 10) {
            return CARD_LIST[Random - 10];
        }
        return String.valueOf(Random);
    }
}
