package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class TryCountTest extends NsTest {
    @Test
    void 시도횟수_0_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,def", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_음수_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,def", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_문자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,def", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_공백_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,def", " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
