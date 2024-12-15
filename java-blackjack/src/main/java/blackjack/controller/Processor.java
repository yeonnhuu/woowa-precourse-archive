package blackjack.controller;

import blackjack.domain.card.CardBox;
import blackjack.domain.user.User;
import blackjack.util.RepeatExecutor;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class Processor {
    protected final InputView inputView = new InputView();
    protected final OutputView outputView = new OutputView();
    protected final RepeatExecutor repeatExecutor = new RepeatExecutor(outputView);
    protected final CardBox cardBox = new CardBox();

    public void distributeCard(User user) {
        user.addCard(cardBox.hit());
    }
}
