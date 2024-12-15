package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class CarNameTest extends NsTest {
    @Test
    void 자동차_이름_빈_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,,def"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_공백_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc, ,def"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_5자_초과_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abcdef,abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_중복_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,abc,aa"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
