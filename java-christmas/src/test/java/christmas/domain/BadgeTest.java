package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import org.junit.jupiter.api.Test;

class BadgeTest extends NsTest {
    private Badge badge;

    @Test
    void 배지_없음_기능() {
        badge = Badge.getBadge(2500);
        assertThat(badge).isEqualTo(Badge.NONE);
    }

    @Test
    void 배지_별_기능() {
        badge = Badge.getBadge(5000);
        assertThat(badge).isEqualTo(Badge.STAR);
    }

    @Test
    void 배지_트리_기능() {
        badge = Badge.getBadge(10000);
        assertThat(badge).isEqualTo(Badge.TREE);
    }

    @Test
    void 배지_산타_기능() {
        badge = Badge.getBadge(20000);
        assertThat(badge).isEqualTo(Badge.SANTA);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
