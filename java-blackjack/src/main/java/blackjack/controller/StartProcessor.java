package blackjack.controller;

import static blackjack.domain.card.CardConstants.INITIAL_CARDS;
import static blackjack.handler.ErrorHandler.INVALID_BETTING_MONEY;

import blackjack.domain.user.Dealer;
import blackjack.domain.user.Player;
import blackjack.domain.user.User;
import blackjack.validator.BettingMoneyValidator;
import blackjack.validator.PlayerNameValidator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StartProcessor extends Processor {
    private final PlayerNameValidator playerNameValidator = new PlayerNameValidator();
    private final BettingMoneyValidator bettingMoneyValidator = new BettingMoneyValidator();
    private final Dealer dealer = new Dealer();
    private final List<Player> players = new ArrayList<>();

    public Dealer registerGameDealer() {
        return dealer;
    }

    public List<Player> registerGamePlayers() {
        processFirstDistribution();
        return players;
    }

    private void processFirstDistribution() {
        initializeFirstDistribution();
        outputView.printFirstDistribution(dealer, players);
    }

    private void initializeFirstDistribution() {
        List<String> playerNames = getPlayerNames();
        initializeDistribution(dealer);

        for (String playerName : playerNames) {
            int bettingMoney = getBettingMoney(playerName);
            Player player = new Player(playerName, bettingMoney);
            initializeDistribution(player);
            players.add(player);
        }
    }

    private void initializeDistribution(User user) {
        IntStream.range(0, INITIAL_CARDS).forEach(i -> distributeCard(user));
    }

    private List<String> getPlayerNames() {
        return repeatExecutor.repeatUntilSuccess(() -> {
            String input = inputView.readPlayerNames();
            return playerNameValidator.validateAndParsePlayerNames(input);
        });
    }

    private int getBettingMoney(String name) {
        return repeatExecutor.repeatUntilSuccess(() -> {
            String input = inputView.readPlayerBettingMoney(name);
            return bettingMoneyValidator.validateAndParseBettingMoney(input);
        });
    }
}
