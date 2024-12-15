package christmas.domain;

import static christmas.constants.CartConstants.*;

import java.util.List;

public class Cart {
    private final Orders orders;
    private final int totalPrice;
    private Order freeOrder;
    private final Promotion promotion;
    private Badge badge;

    public Cart(Orders orders) {
        this.orders = orders;
        this.totalPrice = calculateTotalPrice(orders);
        this.freeOrder = null;
        this.promotion = new Promotion();
        this.badge = Badge.NONE;
    }

    public List<Order> getOrders() {
        return orders.getOrders();
    }

    public Order getFreeOrder() {
        return freeOrder;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public Badge getBadge() {
        return badge;
    }

    private int calculateTotalPrice(Orders orders) {
        return orders.getOrders().stream()
                .mapToInt(Order::getPrice)
                .sum();
    }

    public boolean applyDiscount() {
        return totalPrice >= MIN_DISCOUNT_APPLY_PRICE;
    }

    public void calculatePromotion(Visit visit) {
        promotion.calculateDiscount(orders, visit);
        performFinalChecks();
    }

    private void performFinalChecks() {
        checkFreeEvent();
        checkCartBadge();
    }

    private void checkFreeEvent() {
        if (totalPrice >= MIN_FREE_EVENT_PRICE) {
            this.freeOrder = FREE_ORDER;
            promotion.calculateFreeDiscount(freeOrder);
        }
    }

    private void checkCartBadge() {
        int totalDiscount = promotion.totalDiscount();
        this.badge = Badge.getBadge(totalDiscount);
    }
}
