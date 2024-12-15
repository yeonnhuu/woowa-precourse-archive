package store.service;

import java.io.IOException;
import store.domain.Products;
import store.domain.Promotions;
import store.handler.ProductsFileHandler;
import store.handler.PromotionsFileHandler;
import store.util.RepeatExecutor;
import store.util.Validator;
import store.view.InputView;
import store.view.OutputView;

public class StoreService {
    private final PromotionsFileHandler promotionsFileHandler = new PromotionsFileHandler();
    private final ProductsFileHandler productsFileHandler = new ProductsFileHandler();
    private Promotions promotions;
    private Products products;

    public Promotions initializePromotions() throws IOException {
        promotions = promotionsFileHandler.generatePromotions();
        return promotions;
    }

    public Products initializeProducts() throws IOException {
        products = productsFileHandler.generateProducts(promotions);
        return products;
    }

    public void printStoreStatus() {
        OutputView.printStoreStatus(products);
    }

    public boolean checkContinue() {
        return RepeatExecutor.repeatUntilSuccess(() -> {
            String input = InputView.readServiceContinue();
            Validator.validateYesNoInput(input);
            return input.equals("Y");
        });
    }
}
