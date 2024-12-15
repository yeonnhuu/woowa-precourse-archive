package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class BalanceCoins extends Coins {
    private static final Coin MINIMUM_COIN = Coin.COIN_10;
    private static final Map<Integer, Coin> COINS = Arrays.stream(Coin.values())
            .collect(Collectors.toMap(Coin::getAmount, coin -> coin));

    public BalanceCoins() {
        super();
    }

    public void calculateCoins(VendingCoins vendingCoins, int amount) {
        while (amount >= MINIMUM_COIN.getAmount()) {
            int coinAmount = Randoms.pickNumberInList(new ArrayList<>(COINS.keySet()));
            Coin coin = COINS.get(coinAmount);
            int count = amount / coinAmount;
            if (count > 0) {
                int vendingCount = vendingCoins.getCount(coin);
                int balanceCount = Math.min(count, vendingCount);
                coins.put(coin, balanceCount);
                amount -= balanceCount * coinAmount;
            }
        }
    }
}
