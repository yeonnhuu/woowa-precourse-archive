package baseball.validator;

public class GameContinueValidator {

    public boolean validateAndParse(String input) {
        validate(input);
        return input.equals("1");
    }

    private void validate(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("Game continue must be 1 or 2");
        }
    }
}
