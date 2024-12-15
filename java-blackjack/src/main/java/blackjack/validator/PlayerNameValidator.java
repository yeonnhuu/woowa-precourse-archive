package blackjack.validator;

import static blackjack.handler.ErrorHandler.INVALID_NAME;

import java.util.ArrayList;
import java.util.List;

public class PlayerNameValidator {

    public List<String> validateAndParsePlayerNames(String input) {
        String[] playerNames = input.split(",");
        List<String> names = new ArrayList<>();
        for (String playerName : playerNames) {
            String name = playerName.trim();
            validatePlayerName(names, name);
            names.add(name);
        }
        return names;
    }

    private void validatePlayerName(List<String> names, String name) {
        validatePlayerNameEmpty(name);
        validatePlayerNameDuplicate(names, name);
    }

    private void validatePlayerNameEmpty(String name) {
        if (name.isEmpty()) {
            throw INVALID_NAME.getException();
        }
    }

    private void validatePlayerNameDuplicate(List<String> names, String name) {
        if (names.contains(name)) {
            throw INVALID_NAME.getException();
        }
    }
}
