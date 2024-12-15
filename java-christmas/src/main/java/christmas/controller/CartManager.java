package christmas.controller;

import christmas.domain.Badge;
import christmas.domain.Cart;
import christmas.domain.Order;
import christmas.domain.Promotion;
import java.util.Map;
import java.util.stream.Collectors;

public class CartManager {
    private final Cart cart;
    private final Promotion promotion;

    public CartManager(Cart cart) {
        this.cart = cart;
        this.promotion = cart.getPromotion();
    }

    public Map<String, Integer> getOrders() {
        return cart.getOrders()
                .stream()
                .collect(Collectors.toMap(Order::getName, Order::getQuantity));
    }

    public int getTotalPrice() {
        return cart.getOrders()
                .stream()
                .mapToInt(Order::getPrice)
                .sum();
    }

    public Map<String, Integer> getFreeOrder() {
        Order freeOrder = cart.getFreeOrder();
        if (freeOrder != null) {
            return Map.of(freeOrder.getName(), freeOrder.getQuantity());
        }
        return Map.of();
    }

    public Map<String, Integer> getPromotionDiscounts() {
        return promotion.getDiscounts();
    }

    public int getTotalPromotionDiscount() {
        return promotion.totalDiscount();
    }

    public int getFinalPrice() {
        return getTotalPrice() - promotion.finalDiscount();
    }

    public String getEventBadge() {
        Badge badge = cart.getBadge();
        return badge.getName();
    }
}
