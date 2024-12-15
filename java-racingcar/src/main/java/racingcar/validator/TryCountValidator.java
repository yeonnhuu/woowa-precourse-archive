package racingcar.validator;

import static racingcar.handler.ErrorHandler.TRY_COUNT_NUMBER;
import static racingcar.handler.ErrorHandler.TRY_COUNT_POSITIVE;

public class TryCountValidator {
    private static final int TRY_COUNT_MIN_POSITIVE = 1;

    public int validateAndParse(String input) {
        try {
            int tryCount = Integer.parseInt(input);
            if (tryCount < TRY_COUNT_MIN_POSITIVE) {
                throw TRY_COUNT_POSITIVE.getException();
            }
            return tryCount;
        } catch (NumberFormatException e) {
            throw TRY_COUNT_NUMBER.getException();
        }
    }
}
