package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lotto.Lotto;

public class PurchaseLottos {
    private final List<Lotto> lottos;
    private final Map<Rank, Integer> ranks;

    public PurchaseLottos(PurchaseMoney purchaseMoney) {
        this.lottos = buyLottos(purchaseMoney);
        this.ranks = initializeRanks();
    }

    public List<Lotto> buyLottos(PurchaseMoney purchaseMoney) {
        LottoMachine lottoMachine = new LottoMachine();
        return lottoMachine.generateLottos(purchaseMoney);
    }

    public Map<Rank, Integer> calcuateRanks(PrizeLotto prizeLotto) {
        Map<Rank, Integer> ranks = initializeRanks();
        for (Lotto lotto : lottos) {
            Rank rank = Rank.findLottoRank(lotto, prizeLotto);
            if (rank != null) {
                ranks.put(rank, ranks.get(rank) + 1);
            }
        }
        return ranks;
    }

    private Map<Rank, Integer> initializeRanks() {
        Map<Rank, Integer> map = new TreeMap<>();
        for (Rank rank : Rank.values()) {
            map.put(rank, 0);
        }
        return map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n%d개를 구매했습니다.", lottos.size()));
        for (Lotto lotto : lottos) {
            sb.append("\n").append(lotto.toString());
        }
        return sb.toString();
    }
}
