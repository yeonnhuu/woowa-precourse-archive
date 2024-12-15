package store.view;

import java.util.List;
import java.util.Objects;
import store.domain.Inventory;
import store.domain.Products;

public class OutputView {

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printWelcome() {
        System.out.println("안녕하세요. W편의점입니다.");
    }

    public static void printStoreStatus(Products products) {
        printStoreHeader();
        printStoreProducts(products);
    }

    private static void printStoreHeader() {
        System.out.println("현재 보유하고 있는 상품입니다.\n");
    }

    private static void printStoreProducts(Products products) {
        for (String productName: products.getProductNames()) {
            Inventory inventory = products.getInventory(productName);
            printProductInventory(productName, inventory);
        }
    }

    private static void printProductInventory(String productName, Inventory inventory) {
        for (String promotionName: inventory.getPromotionNames()) {
            List<Integer> stock = inventory.getStock(promotionName);
            String price = formatPrice(stock.getFirst());
            String quantity = formatQuantity(stock.getLast());
            String promotion = formatPromotion(promotionName);
            System.out.printf("- %s %s %s %s%n", productName, price, quantity, promotion);
        }
    }

    private static String formatPrice(int price) {
        return String.format("%,d원", price);
    }

    private static String formatQuantity(int quantity) {
        if (quantity > 0) {
            return String.format("%d개", quantity);
        }
        return "재고 없음";
    }

    private static String formatPromotion(String promotionName) {
        if (!Objects.equals(promotionName, "null")) {
            return promotionName;
        }
        return "";
    }
}
