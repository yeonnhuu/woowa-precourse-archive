package christmas.domain;

import christmas.domain.enums.Badge;
import christmas.domain.enums.Course;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Event {
    private  final List<Integer> specialDays = List.of(3, 10, 17, 24, 25, 31);
    private final int day;
    private final Orders orders;
    private final Promotion promotion;
    private Badge badge;

    public Event(int day, Orders orders) {
        this.day = day;
        this.orders = orders;
        this.promotion = new Promotion();
        this.badge = Badge.NONE;
    }

    public int getDay() {
        return day;
    }

    public void calculatePromotion() {
        if (orders.proceedPromotion()){
            calculateXmasPromotion();
            calculateWeekdayPromotion();
            calculateWeekendPromotion();
            calculateSpecialPromotion();
            calculateExtraPromotion();
            calculatePromotionBadge();
        }
    }

    @Override
    public String toString() {
        return System.lineSeparator() + orders.toString()
                + System.lineSeparator() + promotion.toString()
                + System.lineSeparator() + discountedFinalPriceToString()
                + System.lineSeparator() + badge.toString();
    }

    private void calculateXmasPromotion() {
        if (day <= 25) {
            promotion.calculateXmasDiscount(day-1);
        }
    }

    private void calculateWeekdayPromotion() {
        if (!isWeekend()) {
            int courseMenuCount = orders.countCourseOrders(Course.DESSERTS);
            promotion.calculateWeekdayDiscount(courseMenuCount);
        }
    }

    private void calculateWeekendPromotion() {
        if (isWeekend()) {
            int courseMenuCount = orders.countCourseOrders(Course.MAIN_DISHES);
            System.out.println(courseMenuCount);
            promotion.calculateWeekendDiscount(courseMenuCount);
        }
    }

    private void calculateSpecialPromotion() {
        if (specialDays.contains(day)) {
            promotion.calculateSpecialDiscount();
        }
    }

    private void calculateExtraPromotion() {
        promotion.calculateExtraDiscount(orders.getExtraOrder());
    }

    private void calculatePromotionBadge() {
        int promotionDiscount = promotion.totalDiscount();
        this.badge = Badge.calculateBadge(promotionDiscount);
    }

    private boolean isWeekend() {
        DayOfWeek dayOfWeek = LocalDate.of(2023, 12, day).getDayOfWeek();
        return dayOfWeek.equals(DayOfWeek.FRIDAY) || dayOfWeek.equals(DayOfWeek.SATURDAY);
    }

    private String discountedFinalPriceToString() {
        int discountedFinalPrice = orders.getFinalPrice() - promotion.totalDiscount();
        return "<할인 후 예상 결제 금액>" + System.lineSeparator()
                + String.format("%,d원", discountedFinalPrice) + System.lineSeparator();
    }
}
