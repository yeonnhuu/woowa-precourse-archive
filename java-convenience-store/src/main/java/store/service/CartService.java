package store.service;

import java.util.List;
import store.domain.Cart;
import store.domain.Products;
import store.util.RepeatExecutor;
import store.util.Validator;
import store.view.InputView;

public class CartService {
    private final Products products;
    private Cart cart;

    public CartService(Products products) {
        this.products = products;
    }

    public Cart initializeCart() {
        this.cart = new Cart();
        return cart;
    }

    public void processCartItems() {
        RepeatExecutor.repeatUntilSuccess(() -> {
            String input = InputView.readCartItems();
            processItems(input);
            return null;
        });
    }

    private void processItems(String input) {
        List<String> purchases = List.of(input.split(","));
        for (String purchase : purchases) {
            processSingleItem(purchase);
        }
    }

    private void processSingleItem(String purchase) {
        Validator.validateItemGroupBracket(purchase);
        List<String> item = extractItemDetails(purchase);
        String name = validateAndExtractName(item);
        int quantity = validateAndExtractQuantity(name, item);
        cart.addItem(name, quantity);
    }

    private List<String> extractItemDetails(String purchase) {
        String details = purchase.substring(1, purchase.length() - 1); // Remove brackets
        List<String> item = List.of(details.split("-"));
        Validator.validateItemGroupSize(item);
        return item;
    }

    private String validateAndExtractName(List<String> item) {
        return Validator.validateAndExtractName(products, item.getFirst());
    }

    private int validateAndExtractQuantity(String name, List<String> item) {
        return Validator.validateAndExtractQuantity(products, name, item.getLast());
    }
}
