package blackjack.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import blackjack.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class PlayerNameValidatorTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 플레이어_이름_빈_예외() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 플레이어_이름_공백_예외() {
        assertSimpleTest(() -> {
            runException("pobi, , jason");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 플레이어_이름_중복_예외() {
        assertSimpleTest(() -> {
            runException("pobi, pobi, jason");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
