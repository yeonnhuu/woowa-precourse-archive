package racingcar.handler;

import static racingcar.handler.ErrorHandler.INVALID_INPUT;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationHandler {
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final String TRY_COUNT_PATTERN = "^[1-9][0-9]*$";

    public void validateInput(String input) {
        validateClear(input);
    }

    private void validateClear(String str) {
        if (str == null || str.isBlank()) {
            throw INVALID_INPUT.getException();
        }
    }

    public void validateName(String name) {
        validateClear(name);
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw INVALID_INPUT.getException();
        }
    }

    public void validateNames(List<String> names) {
        if (names.stream().distinct().count() != names.size()) {
            throw INVALID_INPUT.getException();
        }
    }

    public void validateTryCount(String tryCount) {
        Pattern pattern = Pattern.compile(TRY_COUNT_PATTERN);
        Matcher matcher = pattern.matcher(tryCount);
        if (!matcher.matches()) {
            throw INVALID_INPUT.getException();
        }
    }
}
