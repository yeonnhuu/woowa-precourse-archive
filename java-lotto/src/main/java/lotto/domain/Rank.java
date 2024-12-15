package lotto.domain;

import lotto.Lotto;

public enum Rank {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean requireBonus;
    private final int prizeMoney;

    Rank(int matchCount, boolean requireBonus, int prizeMoney) {
        this.matchCount = matchCount;
        this.requireBonus = requireBonus;
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d개 일치", matchCount));
        if (requireBonus) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(String.format(" (%,d원)", prizeMoney));
        return sb.toString();
    }

    public static Rank findLottoRank(Lotto lotto, PrizeLotto prizeLotto) {
        for (Rank rank : values()) {
            if (isRank(rank, lotto, prizeLotto)) {
                return rank;
            }
        }
        return null;
    }

    private static boolean isRank(Rank rank, Lotto lotto, PrizeLotto prizeLotto) {
        return rank.matchCount == prizeLotto.calculateMatchCount(lotto)
                && rank.requireBonus == prizeLotto.calculateRequireBonus(lotto);
    }
}