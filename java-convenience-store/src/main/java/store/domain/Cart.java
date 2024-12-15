package store.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Cart {
    private final Map<String, Integer> cart;

    public Cart() {
        cart = new LinkedHashMap<>();
    }

    public List<Entry<String, Integer>> getItems() {
        return cart.entrySet()
                .stream()
                .toList();
    };

    public void addItem(String name, int quantity) {
        cart.put(name, quantity);
    }
}
