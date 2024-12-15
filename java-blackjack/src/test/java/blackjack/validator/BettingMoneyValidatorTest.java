package blackjack.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import blackjack.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class BettingMoneyValidatorTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 배팅_금액_문자_예외() {
        assertSimpleTest(() -> {
            runException("pobi, jason, woni", "10000", "abc", "20000", "3000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 배팅_금액_공백_예외() {
        assertSimpleTest(() -> {
            runException("pobi, jason, woni", "10000", " ", "20000", "30000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 배팅_금액_0_예외() {
        assertSimpleTest(() -> {
            runException("pobi, jason, woni", "10000", "0", "20000", "30000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 배팅_금액_음수_예외() {
        assertSimpleTest(() -> {
            runException("pobi, jason, woni", "10000", "-15000", "20000", "30000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
