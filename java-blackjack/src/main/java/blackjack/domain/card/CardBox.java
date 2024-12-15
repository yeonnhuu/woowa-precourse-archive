package blackjack.domain.card;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public class CardBox {
    private List<Card> cardBox;

    public CardBox() {
        this.cardBox = initializeCardBox();
    }

    public Card hit() {
        return cardBox.removeFirst();
    }

    private List<Card> initializeCardBox() {
        cardBox = generateCards();
        return Randoms.shuffle(cardBox);
    }

    private List<Card> generateCards() {
        return Arrays.stream(Symbol.values())
                .flatMap(symbol -> Arrays.stream(Type.values())
                        .map(type -> new Card(symbol, type)))
                .toList();
    }
}
