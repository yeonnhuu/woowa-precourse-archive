package blackjack.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import blackjack.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class YesNoValidatorTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 예_아니오_문자열_예외() {
        assertSimpleTest(() -> {
            runException("pobi, jason, woni", "10000", "15000", "20000", "n", "yes", "y", "n");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예_아니오_대문자_예외() {
        assertSimpleTest(() -> {
            runException("pobi, jason, woni", "10000", "15000", "20000", "n", "Y", "y", "n");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
