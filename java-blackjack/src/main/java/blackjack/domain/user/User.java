package blackjack.domain.user;

import static blackjack.domain.card.CardConstants.ACE_SCORE_DIFF;
import static blackjack.domain.card.CardConstants.INITIAL_CARDS;
import static blackjack.domain.card.CardConstants.WIN_SCORE;

import blackjack.domain.card.Card;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private final List<Card> cards = new ArrayList<>();
    private final List<Integer> scores = new ArrayList<>();
    private Status status = Status.PLAY;
    private int profit = 0;
    protected int totalScore = 0;

    public void addCard(Card card) {
        cards.add(card);
        updateTotalScore(card);
        status = updateStatus();
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int findTotalScore() {
        return scores.stream()
                .mapToInt(score -> score)
                .filter(score -> score <= WIN_SCORE)
                .max()
                .orElse(scores.getLast());
    }

    public int getProfit() {
        return profit;
    }

    public boolean isPlayingGame() {
        return status.equals(Status.PLAY);
    }

    public void addProfit(double profit) {
        this.profit += (int) profit;
    }

    public boolean checkStatus(Status status) {
        return this.status.equals(status);
    }

    protected Status updateStatus() {
        if (totalScore == WIN_SCORE && cards.size() == INITIAL_CARDS) {
            return Status.BLACKJACK;
        }
        if (totalScore == WIN_SCORE) {
            return Status.WIN;
        }
        if (totalScore > WIN_SCORE) {
            return Status.BUST;
        }
        return Status.PLAY;
    }

    protected void updateTotalScore(Card card) {
        if (scores.isEmpty()) {
            scores.add(0);
        }
        updateScore(card);
        scores.sort(Comparator.reverseOrder());
        totalScore = findTotalScore();
    }

    protected String cardsToString(String name) {
        return String.format("%s카드: %s", name, cardsString());
    }

    private void updateScore(Card card) {
        for (int i = 0; i < scores.size(); i++) {
            scores.set(i, scores.get(i) + card.getScore());
            if (card.isAce()) {
                scores.add(scores.get(i) + ACE_SCORE_DIFF);
            }
        }
    }

    private String cardsString() {
        return cards.stream()
                .map(Card::toString)
                .collect(Collectors.joining(", "));
    }
}
