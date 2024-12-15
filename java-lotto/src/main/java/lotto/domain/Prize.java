package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import lotto.handler.Rank;

public class Prize {
    private final Map<Rank,Integer> rankCounts;
    private double totalPrizeProfit;

    public Prize() {
        rankCounts = new EnumMap<>(Rank.class);
    }

    public void addRank(Rank rank) {
        rankCounts.put(rank, rankCounts.getOrDefault(rank, 0)+1);
    }

    public double getTotalPrizeProfit() {
        return totalPrizeProfit;
    }

    public void calculateTotalPrizeProfit(int money) {
        this.totalPrizeProfit = (double) getTotalPrizeAmount() / money * 100;
    }

    private int getTotalPrizeAmount() {
        return rankCounts.keySet().stream()
                .mapToInt(integer -> integer.getPrize() * getCount(integer))
                .sum();
    }

    private int getCount(Rank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : Rank.values()) {
            if (rank.getMatchCount() >= 3) {
                sb.append(formatRank(rank));
            }
        }
        return sb.toString();
    }

    private String formatRank(Rank rank) {
        String bonusText = rank.isRequireBonus() ? ", 보너스 볼 일치" : "";
        return String.format(
                "\n%d개 일치%s (%s원) - %d개",
                rank.getMatchCount(),
                bonusText,
                String.format("%,d", rank.getPrize()),
                getCount(rank)
        );
    }
}
