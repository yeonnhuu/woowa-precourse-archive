package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import org.junit.jupiter.api.Test;

class OrderTest extends NsTest {
    private Order order;

    @Test
    void 주문_총_가격_기능() {
        order = new Order("양송이수프", 2);
        assertThat(order.getPrice()).isEqualTo(12000);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
