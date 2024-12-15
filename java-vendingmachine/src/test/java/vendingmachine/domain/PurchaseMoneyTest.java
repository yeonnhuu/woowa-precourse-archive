package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vendingmachine.Application;

class PurchaseMoneyTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private PurchaseMoney purchaseMoney;

    @BeforeEach
    void setUp() {
        purchaseMoney = new PurchaseMoney(2000);
    }

    @Test
    void 구매_금액_계산_기능() {
        purchaseMoney.decreaseAmount(1500);

        assertThat(purchaseMoney.getAmount()).isEqualTo(500);
    }

    void 구매_금액_부족_예외() {
        assertSimpleTest(() -> {
            runException("450","[콜라,1500,20];[사이다,1000,10]","1200","콜라");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
