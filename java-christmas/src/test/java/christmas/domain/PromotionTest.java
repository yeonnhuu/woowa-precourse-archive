package christmas.domain;

import static christmas.constants.PromotionConstants.*;
import static christmas.constants.CartConstants.FREE_ORDER;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PromotionTest extends NsTest {
    private Visit visit;
    private Orders orders;
    private Promotion promotion;
    private Promotion ordersPromotion;
    private Map<String, Integer> promoDiscounts;
    private static final List<String> ordersName = List.of("양송이수프", "티본스테이크", "초코케이크", "레드와인");
    private static final List<Integer> ordersQuantity = List.of(1, 2, 3, 4);

    @BeforeEach
    void setUp() throws Exception {
        visit = new Visit(3);
        orders = new Orders();
        for (int i = 0; i < ordersName.size(); i++) {
            orders.add(new Order(ordersName.get(i), ordersQuantity.get(i)));
        }

        promotion = new Promotion();
        promotion.calculateDiscount(orders, visit);
        promotion.calculateFreeDiscount(FREE_ORDER);

        promoDiscounts = new HashMap<>();
        promoDiscounts.put(XMAS_PROMO, 1200);
        promoDiscounts.put(WEEKDAY_PROMO, WEEKDAY_DISCOUNT*3);   // 6069
        promoDiscounts.put(SPECIAL_PROMO, SPECIAL_DISCOUNT); // 1000
        promoDiscounts.put(FREE_PROMO, 25000);

        ordersPromotion = new Promotion();
        setPrivateField(ordersPromotion, "discounts", promoDiscounts);
    }

    @Test
    void 주문_메뉴_프로모션_계산_기능() {
        assertThat(promotion.getDiscounts()).isEqualTo(ordersPromotion.getDiscounts());
    }

    @Test
    void 주문_메뉴_총_할인_계산_기능() {
        assertThat(promotion.totalDiscount()).isEqualTo(ordersPromotion.totalDiscount());
    }

    @Test
    void 주문_메뉴_최종_할인_계산_기능() {
        assertThat(promotion.finalDiscount()).isEqualTo(ordersPromotion.finalDiscount());
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
