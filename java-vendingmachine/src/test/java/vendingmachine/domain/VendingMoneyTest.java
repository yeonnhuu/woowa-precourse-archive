package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import vendingmachine.Application;

class VendingMoneyTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 자판기_보유_금액_공백_예외() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 자판기_보유_금액_10단위_예외() {
        assertSimpleTest(() -> {
            runException("1234");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 자판기_보유_금액_문자열_예외() {
        assertSimpleTest(() -> {
            runException("2000a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 자판기_보유_금액_음수_예외() {
        assertSimpleTest(() -> {
            runException("-1200");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
