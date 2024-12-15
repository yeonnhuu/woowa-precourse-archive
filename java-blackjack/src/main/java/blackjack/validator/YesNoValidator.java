package blackjack.validator;

import static blackjack.handler.ErrorHandler.INVALID_INPUT;

public class YesNoValidator {

    public boolean validateAndParseYesNo(String input) {
        validateYesNo(input);
        return input.equals("y");
    }

    private void validateYesNo(String input) {
        if (!input.equals("y") && !input.equals("n")) {
            throw INVALID_INPUT.getException();
        }
    }
}
