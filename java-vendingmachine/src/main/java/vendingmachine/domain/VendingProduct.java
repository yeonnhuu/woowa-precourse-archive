package vendingmachine.domain;

import static vendingmachine.handler.ErrorHandler.PURCHASE_PRODUCT_QUANTITY;

public class VendingProduct {
    private final String name;
    private final int price;
    private int quantity;

    public VendingProduct(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decreaseQuantity() {
        if (quantity == 0) {
            throw PURCHASE_PRODUCT_QUANTITY.getException();
        }
        quantity--;
    }


}
