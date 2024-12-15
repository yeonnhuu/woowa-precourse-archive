package vendingmachine.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Coins {
    public final Map<Coin, Integer> coins;

    public Coins() {
        this.coins = new EnumMap<>(Coin.class);
    }

    public int getCount(Coin coin) {
        return coins.get(coin);
    }

    @Override
    public String toString() {
        return coins.entrySet().stream()
                .map(entry -> String.format("%d원 - %d개", entry.getKey().getAmount(), entry.getValue()))
                .collect(Collectors.joining("\n","",""));
    }
}
