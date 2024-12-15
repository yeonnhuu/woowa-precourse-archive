package blackjack.validator;

import static blackjack.handler.ErrorHandler.INVALID_BETTING_MONEY;

public class BettingMoneyValidator {

    public int validateAndParseBettingMoney(String input) {
        try {
            int value = Integer.parseInt(input.trim());
            validateBettingMoneyRange(value);
            return value;
        } catch (NumberFormatException exception) {
            throw INVALID_BETTING_MONEY.getException();
        }
    }

    private void validateBettingMoneyRange(int value) {
        if (value <= 0) {
            throw INVALID_BETTING_MONEY.getException();
        }
    }
}
