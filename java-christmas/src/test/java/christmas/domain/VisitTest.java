package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import org.junit.jupiter.api.Test;

class VisitTest extends NsTest {
    private Visit visit;

    @Test
    void 크리스마스_이전_확인_기능() {
        visit = new Visit(25);
        assertThat(visit.isBeforeChristmas()).isEqualTo(true);
    }

    @Test
    void 크리스마스_이후_확인_기능() {
        visit = new Visit(26);
        assertThat(visit.isBeforeChristmas()).isEqualTo(false);
    }

    @Test
    void 평일_확인_기능() {
        visit = new Visit(2);
        assertThat(visit.isBeforeChristmas()).isEqualTo(true);
    }

    @Test
    void 주말_확인_기능() {
        visit = new Visit(3);
        assertThat(visit.isBeforeChristmas()).isEqualTo(true);
    }

    @Test
    void 특별한_날_확인_기능() {
        visit = new Visit(4);
        assertThat(visit.isBeforeChristmas()).isEqualTo(true);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
