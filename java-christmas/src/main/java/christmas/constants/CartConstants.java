package christmas.constants;

import christmas.domain.Order;

public class CartConstants {
    public static final int MIN_DISCOUNT_APPLY_PRICE = 10_000;
    public static final int MIN_FREE_EVENT_PRICE = 120_000;
    public static final Order FREE_ORDER = new Order("샴페인", 1);
}
