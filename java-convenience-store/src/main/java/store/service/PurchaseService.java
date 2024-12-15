package store.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import store.domain.Cart;
import store.domain.Products;
import store.domain.Promotions;
import store.util.RepeatExecutor;
import store.util.Validator;
import store.view.InputView;

public class PurchaseService {
    private Products products;
    private Promotions promotions;
    private Cart cart;

    public PurchaseService(Products products, Promotions promotions, Cart cart) {
        this.products = products;
        this.promotions = promotions;
        this.cart = cart;
    }

    public void processPurchase() {
        for (Entry<String, Integer> item: cart.getItems()) {
            String itemName = item.getKey();
            int itemQuantity = item.getValue();

            Map<String, List<Integer>> promos = products.getPromotions(itemName);
            for (Map.Entry<String, List<Integer>> promo : promos.entrySet()) {
                String promoName = promo.getKey();
                List<Integer> promoInfo= promo.getValue();
                int promoPrice = promoInfo.getFirst();
                int promoQuantity = promoInfo.getLast();

                List<Integer> eventBuyGet = promotions.getEventBuyGet(promoName);
                int buy = eventBuyGet.getFirst();
                int get = eventBuyGet.getLast();
                int cycle = buy + get;

                // More code
            }
        }
    }

    public boolean getNonPromotionPurchase(String name, int quantity) {
        return RepeatExecutor.repeatUntilSuccess(() -> {
            String input = InputView.readNonPromotionPurchase(name, quantity);
            Validator.validateYesNoInput(input);
            return input.equals("Y");
        });
    }

    public boolean getAddFreeProduct(String name, int quantity) {
        return RepeatExecutor.repeatUntilSuccess(() -> {
            String input = InputView.readAddFreeProduct(name, quantity);
            Validator.validateYesNoInput(input);
            return input.equals("Y");
        });
    }

    public boolean getMembershipDiscount() {
        return RepeatExecutor.repeatUntilSuccess(() -> {
            String input = InputView.readMembershipDiscount();
            Validator.validateYesNoInput(input);
            return input.equals("Y");
        });
    }
}
