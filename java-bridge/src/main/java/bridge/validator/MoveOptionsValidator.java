package bridge.validator;

import static bridge.handler.ErrorArgumentHandler.INVALID_MOVE_OPTION_COMMAND;

import bridge.domain.enums.MoveOptions;

public class MoveOptionsValidator {

    public static String validateAndParse(String input) {
        validate(input);
        return input.trim();
    }

    public static void validate(String input) {
        if (!input.equals(MoveOptions.U.name()) && !input.equals(MoveOptions.D.name())) {
            throw INVALID_MOVE_OPTION_COMMAND.getException();
        }
    }
}
