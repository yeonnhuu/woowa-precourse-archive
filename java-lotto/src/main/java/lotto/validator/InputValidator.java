package lotto.validator;

import static lotto.handler.ErrorHandler.INVALID_BONUS_NUMBER_DIGIT;
import static lotto.handler.ErrorHandler.INVALID_PURCHASE_MONEY_DIGIT;
import static lotto.handler.ErrorHandler.INVALID_WINNING_NUMBER_DIGIT;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    public int validateAndParsePurchaseMoney(String input) {
        try {
            return parseInt(input);
        } catch (NumberFormatException e) {
            throw INVALID_PURCHASE_MONEY_DIGIT.getException();
        }
    }

    public List<Integer> validateAndParseWinningNumbers(String input) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number: input.split(",")) {
            winningNumbers.add(validateAndParseWinningNumber(number));
        }
        return winningNumbers;
    }

    private int validateAndParseWinningNumber(String input) {
        try {
            return parseInt(input);
        } catch (NumberFormatException e) {
            throw INVALID_WINNING_NUMBER_DIGIT.getException();
        }
    }

    public int validateAndParseBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw INVALID_BONUS_NUMBER_DIGIT.getException();
        }
    }

    private int parseInt(String input) {
        return Integer.parseInt(input);
    }

}
