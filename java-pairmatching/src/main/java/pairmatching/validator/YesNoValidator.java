package pairmatching.validator;

import static pairmatching.handler.ErrorHandler.INVALID_INPUT;

public class YesNoValidator {

    public boolean validateAndParseYesNo(String input) {
        validateYesNo(input);
        return input.equals("네");
    }

    private void validateYesNo(String input) {
        if (!input.equals("네") && !input.equals("아니오")) {
            throw INVALID_INPUT.getException();
        }
    }
}
