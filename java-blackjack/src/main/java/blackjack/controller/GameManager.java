package blackjack.controller;

import blackjack.controller.user.DealerProcessor;
import blackjack.controller.user.PlayersProcessor;
import blackjack.controller.user.RoundProcessor;
import blackjack.domain.user.Dealer;
import blackjack.domain.user.Player;
import java.util.List;

public class GameManager {
    private final StartProcessor startProcessor = new StartProcessor();
    private final FinishProcessor finishProcessor = new FinishProcessor();
    private Dealer dealer;
    private List<Player> players;

    public void run() {
        registerGameUsers();
        processGameUsers();
        processGameRound();
        displayGameUsers();
    }

    private void registerGameUsers() {
        dealer = startProcessor.registerGameDealer();
        players = startProcessor.registerGamePlayers();
    }

    private void processGameUsers() {
        PlayersProcessor playersProcessor = new PlayersProcessor(players);
        players = playersProcessor.processPlayersGame();
        DealerProcessor dealerProcessor = new DealerProcessor(dealer);
        dealer = dealerProcessor.processDealerGame();
    }

    private void processGameRound() {
        RoundProcessor roundProcessor = new RoundProcessor(dealer, players);
        roundProcessor.processGameRound();
        dealer = roundProcessor.getDealer();
        players = roundProcessor.getPlayers();
    }

    private void displayGameUsers() {
        finishProcessor.displayGameResult(dealer, players);
    }
}
