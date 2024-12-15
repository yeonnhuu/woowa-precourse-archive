package lotto.domain;

import static lotto.handler.ErrorHandler.INVALID_PURCHASE_MONEY_DIVISION;
import static lotto.handler.ErrorHandler.INVALID_PURCHASE_MONEY_POSITIVE;
import static lotto.util.Constants.LOTTO_TICKET_PRICE;

public class PurchaseMoney {
    private final int money;

    public PurchaseMoney(int money) {
        validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void validate(int money) {
        validatePositive(money);
        validateDivision(money);
    }

    private void validatePositive(int money) {
        if (money < 0) {
            throw INVALID_PURCHASE_MONEY_POSITIVE.getException();
        }
    }

    private void validateDivision(int money) {
        if (money % LOTTO_TICKET_PRICE != 0) {
            throw INVALID_PURCHASE_MONEY_DIVISION.getException();
        }
    }
}
