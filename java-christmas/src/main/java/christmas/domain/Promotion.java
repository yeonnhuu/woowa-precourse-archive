package christmas.domain;

public class Promotion {
    private int xmasDiscount;
    private int weekdayDiscount;
    private int weekendDiscount;
    private int specialDiscount;
    private int extraDiscount;

    public Promotion() {
        this.xmasDiscount = 0;
        this.weekdayDiscount = 0;
        this.weekendDiscount = 0;
        this.specialDiscount = 0;
        this.extraDiscount = 0;
    }

    public void calculateXmasDiscount(int days) {
        this.xmasDiscount = 1000 + 100 * days;
    }

    public void calculateWeekdayDiscount(int menuCount) {
        this.weekdayDiscount = 2023 * menuCount;
    }

    public void calculateWeekendDiscount(int menuCount) {
        this.weekendDiscount = 2023 * menuCount;
    }

    public void calculateSpecialDiscount() {
        this.specialDiscount = 1000;
    }

    public void calculateExtraDiscount(Order extraOrder) {
        if (extraOrder != null) {
            this.extraDiscount = extraOrder.getPrice();
        }
    }

    public int totalDiscount() {
        return xmasDiscount + weekdayDiscount + weekendDiscount + specialDiscount + extraDiscount;
    }

    @Override
    public String toString() {
        return promotionsToString() + totalDiscountToString();
    }

    private String promotionsToString() {
        return "<혜택 내역>" + System.lineSeparator()
                + parsePromotions() + System.lineSeparator();
    }

    private String parsePromotions() {
        String parsedPromotions = parsePromotion("크리스마스 디데이 할인", xmasDiscount)
                + parsePromotion("평일 할인", weekdayDiscount)
                + parsePromotion("주말 할인", weekendDiscount)
                + parsePromotion("특별 할인", specialDiscount)
                + parsePromotion("증정 이벤트", extraDiscount);
        if (parsedPromotions.isBlank()) {
            return "없음" + System.lineSeparator();
        }
        return parsedPromotions;
    }

    private String parsePromotion(String name, int discount) {
        if (discount == 0) {
            return "";
        }
        return String.format("%s: %,d원", name, -discount) + System.lineSeparator();
    }

    private String totalDiscountToString() {
        return "<총혜택 금액>" + System.lineSeparator()
                + String.format("%,d원", -totalDiscount()) + System.lineSeparator();
    }
}
