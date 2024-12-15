package baseball.validator;

import static baseball.util.GameConstants.GAME_MAX_NUMBER;
import static baseball.util.GameConstants.GAME_MIN_NUMBER;
import static baseball.util.GameConstants.GAME_NUMBERS_SIZE;

import java.util.List;

public class NumbersValidator {

    public void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDistinct(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != GAME_NUMBERS_SIZE) {
            throw new IllegalArgumentException("Numbers size error.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < GAME_MIN_NUMBER || number > GAME_MAX_NUMBER) {
                throw new IllegalArgumentException("Number range error.");
            }
        }
    }

    private void validateDistinct(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("Number distinct error.");
        }
    }
}
