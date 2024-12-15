package blackjack.domain.user;

import static blackjack.domain.card.CardConstants.DEALER_STAY_SCORE_MIN;
import static blackjack.domain.card.CardConstants.WIN_SCORE;

import blackjack.domain.card.Card;
import java.util.List;

// 게임 딜러를 의미하는 객체
public class Dealer extends User {
    public Dealer() {}

    public String showCard() {
        List<Card> cards = this.getCards();
        Card showingCard = cards.getFirst();
        return showingCard.toString();
    }

    public boolean isStay() {
        return totalScore > DEALER_STAY_SCORE_MIN && totalScore < WIN_SCORE;
    }

    public String cardsToString() {
        return super.cardsToString("딜러 ");
    }
}
