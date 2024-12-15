package menu.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import menu.Application;
import org.junit.jupiter.api.Test;

public class CoachNamesTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 코치_이름_개수_2명_미만_예외() {
        assertSimpleTest(() -> {
            runException("토미");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 코치_이름_개수_5명_초과_예외() {
        assertSimpleTest(() -> {
            runException("토미,제임스,포코,구구,워니,포비");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 코치_이름_중복_예외() {
        assertSimpleTest(() -> {
            runException("토미,제임스,토미");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 코치_이름_길이_2글자_미만_예외() {
        assertSimpleTest(() -> {
            runException("토미,제임스,포");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 코치_이름_길이_4글자_초과_예외() {
        assertSimpleTest(() -> {
            runException("토미토마스,제임스,포코");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}