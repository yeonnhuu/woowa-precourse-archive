package store.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Inventory {
    private final Map<String, Stock> inventory;

    public Inventory() {
        this.inventory = initializeInventory();
    }

    public List<String> getPromotionNames() {
        return inventory.keySet()
                .stream()
                .toList();
    }

    public List<Integer> getStock(String promotion) {
        Stock stock = inventory.get(promotion);
        return Stream.of(stock.getPrice(), stock.getQuantity()).toList();
    }

    public void addInventoryItem(String promotion, int price, int quantity) {
        inventory.computeIfAbsent(promotion, key -> new Stock(price, 0));
        inventory.computeIfAbsent("null", key -> new Stock(price, 0));

        Stock initalStock = inventory.get(promotion);
        initalStock.addQuantity(quantity);
    }

    public int totalQuantity() {
        return inventory.values()
                .stream()
                .mapToInt(Stock::getQuantity)
                .sum();
    }

    private Map<String, Stock> initializeInventory() {
        return new TreeMap<>(Comparator.comparing((String s) -> {
            if ("null".equals(s)) { // "null" comes last
                return null;
            }
            return s;
        }, Comparator.nullsLast(Comparator.naturalOrder())));
    }

    public void reduceQuantity(String promotionName, int quantity) {
        Stock stock = inventory.get(promotionName);
        stock.reduceQuantity(quantity);
    }
}
