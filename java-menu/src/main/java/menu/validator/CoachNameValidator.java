package menu.validator;

import static menu.handler.ErrorArgumentHandler.COACH_NAME_LENGTH;
import static menu.util.Constants.COACH_NAME_MAX_LENGTH;
import static menu.util.Constants.COACH_NAME_MIN_LENGTH;

public class CoachNameValidator {

    public static void validate(String name) {
        validateLength(name);
    }

    private static void validateLength(String name) {
        if (name.length() < COACH_NAME_MIN_LENGTH || name.length() > COACH_NAME_MAX_LENGTH) {
            throw COACH_NAME_LENGTH.getException();
        }
    }
}
