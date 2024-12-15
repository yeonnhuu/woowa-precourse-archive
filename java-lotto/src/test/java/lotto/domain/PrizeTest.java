package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.handler.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrizeTest extends NsTest {
    private Prize prize;

    @BeforeEach
    void setUp() {
        prize = new Prize();
        prize.addRank(Rank.FOURTH);
        prize.addRank(Rank.FIFTH);
        prize.addRank(Rank.FIFTH);
    }

    @Test
    void 상금_총_수익률_계산() {
        int money = 10000;
        prize.calculateTotalPrizeProfit(money);
        assertThat(prize.getTotalPrizeProfit()).isEqualTo(600);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
