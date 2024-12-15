package blackjack.controller.user;

import blackjack.controller.Processor;
import blackjack.domain.user.Player;
import blackjack.validator.YesNoValidator;
import java.util.List;

public class PlayersProcessor extends Processor {
    private final YesNoValidator yesNoValidator = new YesNoValidator();
    private final List<Player> players;

    public PlayersProcessor(List<Player> players) {
        this.players = players;
    }

    public List<Player> processPlayersGame() {
        processPlayersTurns();
        return players;
    }

    private void processPlayersTurns() {
        for (Player player : players) {
            boolean playerHit = getPlayerHit(player);
            processPlayerTurn(player, playerHit);
        }
    }

    private void processPlayerTurn(Player player, boolean playerHit) {
        if (playerHit) {
            distributeCard(player);
        }
        outputView.printPlayerCards(player);
        if (playerHit) {
            processPlayerContinuousHits(player);
        }
    }

    private void processPlayerContinuousHits(Player player) {
        while (player.isPlayingGame() && getPlayerHit(player)) {
            distributeCard(player);
            outputView.printPlayerCards(player);
        }
    }

    private boolean getPlayerHit(Player player) {
        return repeatExecutor.repeatUntilSuccess(() -> {
            String input = inputView.readPlayerHit(player.getName());
            return yesNoValidator.validateAndParseYesNo(input);
        });
    }
}
