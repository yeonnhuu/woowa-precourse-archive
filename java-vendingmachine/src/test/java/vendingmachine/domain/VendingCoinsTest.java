package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vendingmachine.Application;

class VendingCoinsTest extends NsTest {
    private VendingCoins vendingCoins;

    @BeforeEach
    void setUp() {
        vendingCoins = new VendingCoins();
    }

    @Test
    void 자판기_보유_금액_450_계산_기능() {
        vendingCoins.calculateCoins(450);

        assertThat(vendingCoins.getCount(Coin.COIN_500)).isEqualTo(0);
        assertThat(vendingCoins.getCount(Coin.COIN_100)).isEqualTo(4);
        assertThat(vendingCoins.getCount(Coin.COIN_50)).isEqualTo(1);
        assertThat(vendingCoins.getCount(Coin.COIN_10)).isEqualTo(0);
    }

    @Test
    void 자판기_보유_금액_650_계산_기능() {
        vendingCoins.calculateCoins(660);

        assertThat(vendingCoins.getCount(Coin.COIN_500)).isEqualTo(1);
        assertThat(vendingCoins.getCount(Coin.COIN_100)).isEqualTo(1);
        assertThat(vendingCoins.getCount(Coin.COIN_50)).isEqualTo(1);
        assertThat(vendingCoins.getCount(Coin.COIN_10)).isEqualTo(1);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
