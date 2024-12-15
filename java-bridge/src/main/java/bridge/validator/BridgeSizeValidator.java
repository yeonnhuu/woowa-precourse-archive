package bridge.validator;

import static bridge.handler.ErrorArgumentHandler.INVALID_BRIDGE_SIZE_DIGIT;
import static bridge.handler.ErrorArgumentHandler.INVALID_BRIDGE_SIZE_RANGE;
import static bridge.util.Constants.BRIDGE_MAX_SIZE;
import static bridge.util.Constants.BRIDGE_MIN_SIZE;

public class BridgeSizeValidator {

    public static int validateAndParse(String input) {
        validate(input);
        return Integer.parseInt(input);
    }

    private static void validate(String input) {
        validateDigit(input);
        validateRange(input);
    }

    private static void validateDigit(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw INVALID_BRIDGE_SIZE_DIGIT.getException();
        }
    }

    private static void validateRange(String input) {
        int bridgeSize = Integer.parseInt(input);
        if (bridgeSize < BRIDGE_MIN_SIZE || bridgeSize > BRIDGE_MAX_SIZE) {
            throw INVALID_BRIDGE_SIZE_RANGE.getException();
        }
    }
}
