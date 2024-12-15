package store.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Products {
    private final Map<String, Inventory> products;

    public Products() {
        this.products = new LinkedHashMap<>();
    }

    public Set<String> getProductNames() {
        return products.keySet();
    }

    public Inventory getInventory(String productName) {
        return products.get(productName);
    }

    public Map<String, List<Integer>> getPromotions(String productName) {
        Inventory inventory = products.get(productName);

        Map<String, List<Integer>> promotions = new LinkedHashMap<>();
        List<String> promotionNames = new ArrayList<>(inventory.getPromotionNames()); // Ensure order
        for (String promotionName : promotionNames) {
            promotions.put(promotionName, inventory.getStock(promotionName));
        }
        return promotions;
    }

    public boolean hasProduct(String productName) {
        return products.containsKey(productName);
    }

    public boolean hasEnoughQuantity(String productName, int quantity) {
        Inventory inventory = products.get(productName);
        return inventory.totalQuantity() >= quantity;
    }

    public void addInventory(String name, String promotion, int price, int quantity) {
        products.computeIfAbsent(name, key -> new Inventory())
                .addInventoryItem(promotion, price, quantity);
    }

    public void reduceQuantity(String productName, String promotionName, int quantity) {
        Inventory inventory = products.get(productName);
        inventory.reduceQuantity(promotionName, quantity);
    }
}
