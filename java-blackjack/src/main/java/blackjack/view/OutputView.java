package blackjack.view;

import static blackjack.domain.card.CardConstants.DEALER_STAY_SCORE_MIN;
import static blackjack.domain.card.CardConstants.INITIAL_CARDS;

import blackjack.domain.user.Dealer;
import blackjack.domain.user.Player;
import java.util.List;

public class OutputView {

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printFirstDistribution(Dealer dealer, List<Player> players) {
        System.out.printf("%n딜러와 %s에게 %d장을 나누었습니다.%n", formatPlayerNames(players), INITIAL_CARDS);
        System.out.printf("딜러: %s%n", dealer.showCard());
        for (Player player : players) {
            System.out.printf("%s%n", player.cardsToString());
        }
    }

    public void printDealerHit() {
        System.out.printf("%n딜러는 %d이하라 한 장의 카드를 더 받았습니다.%n", DEALER_STAY_SCORE_MIN);
    }

    public void printPlayerCards(Player player) {
        System.out.printf("%n%s%n", player.cardsToString());
    }

    public void printFinalDistribution(Dealer dealer, List<Player> players) {
        System.out.printf("%n%s - 결과: %d%n", dealer.cardsToString(), dealer.getTotalScore());
        for (Player player : players) {
            System.out.printf("%s - 결과 %d%n", player.cardsToString(), player.getTotalScore());
        }
    }

    public void printFinalProfit(Dealer dealer, List<Player> players) {
        System.out.println("\n## 최종 수익");
        System.out.printf("딜러: %d%n", dealer.getProfit());
        for (Player player : players) {
            System.out.printf("%s: %d%n", player.getName(), player.getProfit());
        }
    }

    private String formatPlayerNames(List<Player> players) {
        List<String> names = generatePlayerNames(players);
        return String.join(", ", names);
    }

    private List<String> generatePlayerNames(List<Player> players) {
        return players.stream()
                .map(Player::getName)
                .toList();
    }
}
