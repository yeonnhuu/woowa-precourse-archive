package vendingmachine.domain;

import static vendingmachine.handler.ErrorHandler.PURCHASE_PRODUCT_NAME;
import static vendingmachine.handler.ErrorHandler.VENDING_PRODUCTS_NAME;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VendingProducts {
    private List<VendingProduct> vendingProducts;

    public VendingProducts() {
        this.vendingProducts = new ArrayList<>();
    }

    public VendingProduct getVendingProductByName(String name) {
        return vendingProducts.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElseThrow(PURCHASE_PRODUCT_NAME::getException);
    }

    public List<String> getName() {
        return vendingProducts.stream()
                .map(VendingProduct::getName)
                .collect(Collectors.toList());
    }

    public List<Integer> getPrice() {
        return vendingProducts.stream()
                .map(VendingProduct::getPrice)
                .collect(Collectors.toList());
    }

    public List<Integer> getQuantity() {
        return vendingProducts.stream()
                .map(VendingProduct::getQuantity)
                .collect(Collectors.toList());
    }

    public void addProduct(VendingProduct vendingProduct) {
        validate(vendingProduct);
        vendingProducts.add(vendingProduct);
    }

    private void validate(VendingProduct vendingProduct) {
        if (getName().contains(vendingProduct.getName())) {
            throw VENDING_PRODUCTS_NAME.getException();
        }
    }
}
