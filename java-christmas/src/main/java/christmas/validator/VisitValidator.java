package christmas.validator;

import static christmas.constants.VisitConstants.*;
import static christmas.handler.ErrorHandler.INVALID_VISIT;

public class VisitValidator {

    public void validateVisit(String value) {
        validateVisitInput(value);
        validateVisitRange(Integer.parseInt(value));
    }

    private void validateVisitInput(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw INVALID_VISIT.getException();
        }
    }

    private void validateVisitRange(int value) {
        if (value < VISIT_MIN || value > VISIT_MAX) {
            throw INVALID_VISIT.getException();
        }
    }
}
