package blackjack.Model;

import blackjack.Model.Card.Card;
import blackjack.Model.Card.CardType;
import blackjack.Model.Card.Denomination;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CardFactory {
    static List<Denomination> CARD_LIST = Arrays.stream(Denomination.values()).collect(Collectors.toList());
    static List<CardType> CARD_TYPE_LIST = Arrays.stream(CardType.values()).toList();

    public static List<Card> generateCard(List<Card> cardList) {
        int RandomNumber = (int) (Math.random() * 12);
        int RandomType = (int) (Math.random() * 3);
        cardList.add(new Card(CARD_LIST.get(RandomNumber), CARD_TYPE_LIST.get(RandomType)));
        return cardList;
    }
}
