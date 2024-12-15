package vendingmachine.domain;

import static vendingmachine.handler.ErrorHandler.PURCHASE_PRODUCT_PRICE;

public class PurchaseMoney {
    private int amount;

    public PurchaseMoney(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void decreaseAmount(int value) {
        if (value > amount) {
            throw PURCHASE_PRODUCT_PRICE.getException();
        }
        amount -= value;
    }
}
