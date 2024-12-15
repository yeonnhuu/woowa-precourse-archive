package christmas.view;

import christmas.controller.CartManager;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printWelcome() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printEventHeader(int day) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!%n", day);
    }

    public void printEvent(CartManager cartManager) {
        printOrders(cartManager.getOrders());
        printTotalPrice(cartManager.getTotalPrice());
        printFreeOrder(cartManager.getFreeOrder());
        printPromotionDiscounts(cartManager.getPromotionDiscounts());
        printTotalPromotionDiscount(cartManager.getTotalPromotionDiscount());
        printFinalPrice(cartManager.getFinalPrice());
        printEventBadge(cartManager.getEventBadge());
    }

    private void printOrders(Map<String, Integer> orders) {
        System.out.println("\n<주문 메뉴>");
        for (Entry<String, Integer> entry : orders.entrySet()) {
            System.out.printf("%s %d개%n", entry.getKey(), entry.getValue());
        }
    }

    private void printTotalPrice(int totalPrice) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.printf("%,d원%n", totalPrice);
    }

    private void printFreeOrder(Map<String, Integer> freeOrder) {
        System.out.println("\n<증정 메뉴>");
        if (freeOrder.isEmpty()) {
            System.out.println("없음");
            return;
        }
        for (Entry<String, Integer> entry : freeOrder.entrySet()) {
            System.out.printf("%s %d개%n", entry.getKey(), entry.getValue());
        }
    }

    private void printPromotionDiscounts(Map<String, Integer> discounts) {
        System.out.println("\n<혜택 내역>");
        if (discounts.isEmpty()) {
            System.out.println("없음");
            return;
        }
        for (Entry<String, Integer> entry : discounts.entrySet()) {
            System.out.printf("%s: %,d원%n", entry.getKey(), -entry.getValue());
        }
    }

    private void printTotalPromotionDiscount(int totalDiscount) {
        System.out.println("\n<총혜택 금액>");
        System.out.printf("%,d원%n", -totalDiscount);
    }

    private void printFinalPrice(int finalPrice) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.printf("%,d원%n", finalPrice);
    }

    private void printEventBadge(String badgeName) {
        System.out.println("\n<12월 이벤트 배지>");
        System.out.printf("%s%n", badgeName);
    }
}
