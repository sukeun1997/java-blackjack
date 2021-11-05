package blackjack_feedback.model.cardState;

import blackjack_feedback.model.Card;
import blackjack_feedback.model.CardDeck;

public interface State {

    State draw(Card card);

    State stay();

    boolean isFinished();

    CardDeck cards();

    double profit(double earn);

}
