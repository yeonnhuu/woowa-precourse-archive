package blackjack.controller.user;

import blackjack.controller.Processor;
import blackjack.domain.user.Dealer;

public class DealerProcessor extends Processor {
    private final Dealer dealer;

    public DealerProcessor(Dealer dealer) {
        this.dealer = dealer;
    }

    public Dealer processDealerGame() {
        processDealerTurn();
        return dealer;
    }

    private void processDealerTurn() {
        if (dealer.isPlayingGame() && !dealer.isStay()) {
            outputView.printDealerHit();
            distributeCard(dealer);
        }
    }
}
