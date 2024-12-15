package vendingmachine.domain;

public class VendingCoins extends Coins {
    public VendingCoins() {
        super();
    }

    public int getCount(Coin coin) {
        return coins.getOrDefault(coin, 0);
    }

    public void calculateCoins(int amount) {
        for (Coin coin : Coin.values()) {
            int count = amount / coin.getAmount();
            coins.put(coin, count);
            amount -= count * coin.getAmount();
        }
    }
}
