package blackjack.controller.user;

import blackjack.controller.Processor;
import blackjack.domain.user.Dealer;
import blackjack.domain.user.Player;
import java.util.List;

public class RoundProcessor extends Processor {
    private final Dealer dealer;
    private final List<Player> players;

    public RoundProcessor(Dealer dealer, List<Player> players) {
        this.dealer = dealer;
        this.players = players;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void processGameRound() {
        for (Player player : players) {
            double statusValue = player.calculateStatusValue(dealer);
            updateProfit(player, statusValue);
        }
    }

    private void updateProfit(Player player, double value) {
        double bettingMoney = player.getBettingMoney() * value;
        player.addProfit(bettingMoney);
        dealer.addProfit(-bettingMoney);
    }
}
