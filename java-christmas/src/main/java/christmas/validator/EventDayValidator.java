package christmas.validator;

import static christmas.handler.ErrorArgumentHandler.INVALID_DATE;

public class EventDayValidator {

    public int validateAndParse(String input) {
        validateDigit(input);
        validateRange(Integer.parseInt(input));
        return Integer.parseInt(input);
    }

    private void validateDigit(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw INVALID_DATE.getException();
        }
    }

    private void validateRange(int day) {
        if (day < 1 || day > 31) {
            throw INVALID_DATE.getException();
        }
    }
}
