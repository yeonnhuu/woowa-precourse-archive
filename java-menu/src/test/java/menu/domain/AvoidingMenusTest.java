package menu.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import menu.Application;
import org.junit.jupiter.api.Test;

public class AvoidingMenusTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 못_먹는_음식_2개_초과_예외() {
        assertSimpleTest(() -> {
            runException("토미,제임스,포코", "우동,스시,뇨끼");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 못_먹는_음식_중복_예외() {
        assertSimpleTest(() -> {
            runException("토미,제임스,포코", "김밥,김밥");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 못_먹는_음식_존재하지_않는_예외() {
        assertSimpleTest(() -> {
            runException("토미,제임스,포코", "김밥,와플");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
