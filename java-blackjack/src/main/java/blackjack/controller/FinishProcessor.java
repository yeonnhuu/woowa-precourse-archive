package blackjack.controller;

import blackjack.domain.user.Dealer;
import blackjack.domain.user.Player;
import java.util.List;

public class FinishProcessor extends Processor {

    public void displayGameResult(Dealer dealer, List<Player> players) {
        outputView.printFinalDistribution(dealer, players);
        outputView.printFinalProfit(dealer, players);
    }
}
