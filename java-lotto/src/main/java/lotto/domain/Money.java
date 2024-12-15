package lotto.domain;

import static lotto.handler.ErrorHandler.INVALID_MONEY;

public class Money {
    private static final int LOTTO_UNIT = 1000;
    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void validate(int amount) {
        if (amount <= 0 || amount % LOTTO_UNIT != 0) {
            throw INVALID_MONEY.getException();
        }
    }
}
