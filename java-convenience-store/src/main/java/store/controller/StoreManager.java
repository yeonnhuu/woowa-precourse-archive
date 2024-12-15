package store.controller;

import java.io.IOException;
import store.domain.Cart;
import store.domain.Products;
import store.domain.Promotions;
import store.service.CartService;
import store.service.PurchaseService;
import store.service.StoreService;
import store.view.OutputView;

public class StoreManager {
    private StoreService storeService;
    private CartService cartService;
    private PurchaseService purchaseService;
    private Products products;
    private Promotions promotions;
    private Cart cart;

    public void run() throws IOException {
        initializeService();
        boolean continueService;
        do {
            startService();
            processService();
            continueService = storeService.checkContinue();
        } while (continueService);
    }

    private void initializeService() throws IOException {
        initializeStoreService();
        initializeCartService();
        initializePurchaseService();
    }

    private void initializeStoreService() throws IOException {
        storeService = new StoreService();
        promotions = storeService.initializePromotions();
        products = storeService.initializeProducts();
    }

    private void initializeCartService() {
        cartService = new CartService(products);
        cart = cartService.initializeCart();
    }

    private void initializePurchaseService() {
        purchaseService = new PurchaseService(products, promotions, cart);
    }

    private void startService() {
        OutputView.printWelcome();
        storeService.printStoreStatus();
    }

    private void processService() {
        cartService.processCartItems();
        purchaseService.processPurchase();
    }
}
