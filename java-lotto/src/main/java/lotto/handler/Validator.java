package lotto.handler;

import static lotto.handler.ErrorHandler.INVALID_INPUT;

import java.util.Arrays;
import java.util.List;

public class Validator {
    public int validateMoney(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw INVALID_INPUT.getException();
        }
    }

    public List<Integer> validateWinningNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw INVALID_INPUT.getException();
        }
    }

    public int validateBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw INVALID_INPUT.getException();
        }
    }
}
