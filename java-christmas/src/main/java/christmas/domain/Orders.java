package christmas.domain;

import christmas.domain.enums.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Orders {
    private final List<Order> orders;
    private int totalPrice;
    private Order extraOrder;

    public Orders() {
        this.orders = new ArrayList<>();
        this.totalPrice = 0;
        this.extraOrder = null;
    }

    public int getFinalPrice() {
        if (extraOrder == null) {
            return totalPrice;
        }
        return totalPrice + extraOrder.getPrice();
    }

    public Order getExtraOrder() {
        return extraOrder;
    }

    public void updateOrders(String name, int quantity) {
        orders.add(new Order(name, quantity));
        updateTotalPrice();
        updateExtraOrder();
    }

    public int countCourseOrders(Course course) {
        int totalCount = 0;
        Set<String> courseMenus = course.getMenuNames();
        for (Order order : orders) {
            if (courseMenus.contains(order.getName())) {
                totalCount += order.getQuantity();
            }
        }
        return totalCount;
    }

    public boolean proceedPromotion() {
        return totalPrice > 10_000;
    }

    @Override
    public String toString() {
        return ordersToString() + System.lineSeparator()
                + totalPriceToString() + System.lineSeparator()
                + extraOrderToString() + System.lineSeparator();
    }

    public String ordersToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<주문 메뉴>").append(System.lineSeparator());
        for (Order order : orders) {
            sb.append(order.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String totalPriceToString() {
        return "<할인 전 총주문 금액>" + System.lineSeparator()
                + String.format("%,d원", totalPrice) + System.lineSeparator();
    }

    public String extraOrderToString() {
        return "<증정 메뉴>" + System.lineSeparator()
                + parseExtraOrder();
    }

    private void updateTotalPrice() {
        this.totalPrice = orders.stream()
                .map(Order::getPrice)
                .reduce(0, Integer::sum);
    }

    private void updateExtraOrder() {
        if (totalPrice > 120_000 && extraOrder == null) {
            this.extraOrder = new Order("샴페인", 1);
        }
    }

    private String parseExtraOrder() {
        if (extraOrder == null) {
            return "없음";
        }
        return extraOrder.toString();
    }
}
