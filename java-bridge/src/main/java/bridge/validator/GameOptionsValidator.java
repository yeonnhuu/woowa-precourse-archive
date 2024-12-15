package bridge.validator;

import static bridge.handler.ErrorArgumentHandler.INVALID_GAME_OPTION_COMMAND;

import bridge.domain.enums.GameOptions;

public class GameOptionsValidator {

    public static boolean validateAndParse(String input) {
        validate(input);
        return input.equals(GameOptions.R.name());
    }

    public static void validate(String input) {
        if (!input.equals(GameOptions.R.name()) && !input.equals(GameOptions.Q.name())) {
            throw INVALID_GAME_OPTION_COMMAND.getException();
        }
    }
}
