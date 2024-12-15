package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vendingmachine.Application;

class BalanceCoinsTest extends NsTest {
    private VendingCoins vendingCoins;
    private BalanceCoins balanceCoins;

    @BeforeEach
    void setUp() {
        vendingCoins = new VendingCoins();
        balanceCoins = new BalanceCoins();

        vendingCoins.calculateCoins(460);
    }

    @Test
    void 구매_잔고_210_계산_기능() {
        balanceCoins.calculateCoins(vendingCoins,210);

        assertThat(balanceCoins.getCount(Coin.COIN_100)).isLessThanOrEqualTo(2);
        assertThat(balanceCoins.getCount(Coin.COIN_10)).isLessThanOrEqualTo(1);
    }

    @Test
    void 구매_잔고_410_계산_기능() {
        balanceCoins.calculateCoins(vendingCoins,500);

        assertThat(balanceCoins.getCount(Coin.COIN_100)).isLessThanOrEqualTo(4);
        assertThat(balanceCoins.getCount(Coin.COIN_10)).isLessThanOrEqualTo(1);
    }

    @Test
    void 구매_잔고_600_계산_기능() {
        balanceCoins.calculateCoins(vendingCoins,600);

        assertThat(balanceCoins.getCount(Coin.COIN_100)).isLessThanOrEqualTo(4);
        assertThat(balanceCoins.getCount(Coin.COIN_50)).isLessThanOrEqualTo(1);
        assertThat(balanceCoins.getCount(Coin.COIN_10)).isLessThanOrEqualTo(1);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
