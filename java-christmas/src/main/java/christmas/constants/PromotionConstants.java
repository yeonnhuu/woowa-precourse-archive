package christmas.constants;

import java.util.List;

public class PromotionConstants {
    public static final String XMAS_PROMO = "크리스마스 디데이 할인";
    public static final String WEEKDAY_PROMO = "평일 할인";
    public static final String WEEKEND_PROMO = "주말 할인";
    public static final String SPECIAL_PROMO = "특별 할인";
    public static final String FREE_PROMO = "증정 이벤트";
    public static final List<String> PROMO_NAMES = List.of(
            XMAS_PROMO, WEEKDAY_PROMO, WEEKEND_PROMO, SPECIAL_PROMO, FREE_PROMO
    );

    public static final int XMAS_DEFAULT_DISCOUNT = 1000;
    public static final int XMAS_EXTRA_DISCOUNT = 100;
    public static final int WEEKDAY_DISCOUNT = 2023;
    public static final int WEEKEND_DISCOUNT = 2023;
    public static final int SPECIAL_DISCOUNT = 1000;
}

