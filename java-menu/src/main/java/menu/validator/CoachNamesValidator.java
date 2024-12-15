package menu.validator;

import static menu.handler.ErrorArgumentHandler.COACH_NAME_DISTINCT;
import static menu.handler.ErrorArgumentHandler.COACH_NAME_NUMBER;
import static menu.util.Constants.COACH_NAME_MAX_NUMBER;
import static menu.util.Constants.COACH_NAME_MIN_NUMBER;

import java.util.List;

public class CoachNamesValidator {

    public static void validate(List<String> names) {
        validateNumber(names);
        validateDistinct(names);
    }

    private static void validateNumber(List<String> names) {
        if (names.size() < COACH_NAME_MIN_NUMBER || names.size() > COACH_NAME_MAX_NUMBER) {
            throw COACH_NAME_NUMBER.getException();
        }
    }

    private static void validateDistinct(List<String> names) {
        if (names.stream().distinct().count() != names.size()) {
            throw COACH_NAME_DISTINCT.getException();
        }
    }
}
