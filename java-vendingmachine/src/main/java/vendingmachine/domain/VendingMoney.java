package vendingmachine.domain;

import vendingmachine.handler.ErrorHandler;

public class VendingMoney {
    private static final int VENDING_MONEY_UNIT = 10;
    private final int amount;

    public VendingMoney(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void validate(int amount) {
        if (amount % VENDING_MONEY_UNIT != 0) {
            throw ErrorHandler.VENDING_MONEY_UNIT.getException();
        }
    }
}
