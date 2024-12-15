package lotto.domain;

import java.util.Map;

public class Prize {
    private final Map<Rank, Integer> ranks;

    public Prize(PurchaseLottos purchaseLottos, PrizeLotto prizeLotto) {
        this.ranks = purchaseLottos.calcuateRanks(prizeLotto);
    }

    public String statisticsToString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Rank, Integer> entry : ranks.entrySet()) {
            sb.append("\n").append(entry.getKey().toString());
            sb.append(" - ").append(String.format("%d개", entry.getValue()));
        }
        return sb.toString();
    }

    public String profitToString(PurchaseMoney purchaseMoney) {
        double profit = (double) totalPrizeMoney() / purchaseMoney.getMoney() * 100;
        return String.format("총 수익률은 %.1f%%입니다.", profit);
    }

    private int totalPrizeMoney() {
        int totalMoney = 0;
        for (Rank rank : ranks.keySet()) {
            totalMoney += rank.getPrizeMoney() * ranks.get(rank);
        }
        return totalMoney;
    }

}
