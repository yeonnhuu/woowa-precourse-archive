package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrdersTest extends NsTest {
    private Orders orders;
    private static final List<String> ordersName = List.of("양송이수프", "티본스테이크", "초코케이크", "제로콜라");
    private static final List<Integer> ordersQuantity = List.of(1, 2, 3, 4);

    @BeforeEach
    void setUp() {
        orders = new Orders();
        for (int i = 0; i < ordersName.size(); i++) {
            orders.add(new Order(ordersName.get(i), ordersQuantity.get(i)));
        }
    }

    @Test
    void 주문_메뉴_이름_리스트_기능() {
        assertThat(orders.getName()).isEqualTo(ordersName);
    }

    @Test
    void 주문_메뉴_수량_리스트_기능() {
        assertThat(orders.getQuantity()).isEqualTo(ordersQuantity);
    }

    @Test
    void 주문_코스_수량_리스트_기능() {
        List<Integer> coursesQuantity = new ArrayList<>();
        for (MenuCourse course: MenuCourse.values()) {
            coursesQuantity.add(orders.getCourseQuantity(course));
        }
        assertThat(coursesQuantity).isEqualTo(ordersQuantity);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
