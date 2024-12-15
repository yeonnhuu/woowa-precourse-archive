package store.handler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import store.domain.Inventory;
import store.domain.Products;
import store.domain.Promotions;
import store.domain.Stock;

public class ProductsFileHandler {
    private static final Path PRODUCTS_PATH = Path.of("src/main/resources/products.md");
    private Products products;
    private Promotions productPromotions;

    public Products generateProducts(Promotions promotions) throws IOException {
        products = new Products();
        productPromotions = promotions;
        List<String> lines = Files.readAllLines(PRODUCTS_PATH);
        for (String line : lines.subList(1, lines.size())) {
            addProductFromLine(line);
        }
        return products;
    }

    private void addProductFromLine(String line) {
        String[] fields = line.split(",");
        String name = fields[0];
        int price = parseInteger(fields[1]);
        int quantity = parseInteger(fields[2]);
        String promotion = getCurrentPromotion(fields[3]);

        products.addInventory(name, promotion, price, quantity);
    }

    private String getCurrentPromotion(String promotion) {
        if (productPromotions.getEvent(promotion) == null) {
            return "null";
        }
        return promotion;
    }

    private int parseInteger(String value) {
        return Integer.parseInt(value);
    }
}
