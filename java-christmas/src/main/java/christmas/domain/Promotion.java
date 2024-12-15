package christmas.domain;

import static christmas.constants.PromotionConstants.*;

import java.util.Map;
import java.util.stream.Collectors;

public class Promotion {
    private final Map<String, Integer> discounts;

    public Promotion() {
        this.discounts = initializeDiscounts();
    }

    private Map<String, Integer> initializeDiscounts() {
        return PROMO_NAMES.stream()
                .collect(Collectors.toMap(promoName -> promoName, promoName -> 0));
    }

    public Map<String, Integer> getDiscounts() {
        return discounts.entrySet()
                .stream()
                .filter(e -> e.getValue() > 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public void calculateDiscount(Orders orders, Visit visit) {
        calculateChristmasDiscount(visit);
        calculateWeekdayDiscount(orders, visit);
        calculateWeekendDiscount(orders, visit);
        calculateSpecialDiscount(visit);
    }

    public void calculateFreeDiscount(Order order) {
        discounts.put(FREE_PROMO, order.getPrice());
    }

    public int totalDiscount() {
        return calculateDiscountSum(discounts);
    }

    public int finalDiscount() {
        return calculateDiscountSum(
                discounts.entrySet()
                        .stream()
                        .filter(entry -> !entry.getKey().equals(FREE_PROMO))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
        );
    }

    private void calculateChristmasDiscount(Visit visit) {
        if (visit.isBeforeChristmas()) {
            discounts.put(XMAS_PROMO, XMAS_DEFAULT_DISCOUNT + (visit.getDay() - 1) * XMAS_EXTRA_DISCOUNT);
        }
    }

    private void calculateWeekdayDiscount(Orders orders, Visit visit) {
        if (!visit.isWeekend()) {
            int quantity = orders.getCourseQuantity(MenuCourse.DESSERTS);
            discounts.put(WEEKDAY_PROMO, WEEKDAY_DISCOUNT * quantity);
        }
    }

    private void calculateWeekendDiscount(Orders orders, Visit visit) {
        if (visit.isWeekend()) {
            int quantity = orders.getCourseQuantity(MenuCourse.MAIN_DISHES);
            discounts.put(WEEKEND_PROMO, WEEKEND_DISCOUNT * quantity);
        }
    }

    private void calculateSpecialDiscount(Visit visit) {
        if (visit.isSpecialDay()) {
            discounts.put(SPECIAL_PROMO, SPECIAL_DISCOUNT);
        }
    }

    private int calculateDiscountSum(Map<String, Integer> discounts) {
        return discounts.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
