package lotto.domain;

import static lotto.handler.ErrorHandler.DUPLICATE_NUMBERS;
import static lotto.handler.ErrorHandler.LOTTO_NUMBER_SIZE;
import static lotto.handler.ErrorHandler.LOTTO_NUMBER_RANGE;

import java.util.List;

public class Lotto {
    private final static int LOTTO_SIZE = 6;
    private final static int LOTTO_MIN_RANGE = 1;
    private final static int LOTTO_MAX_RANGE = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers); // Validate input numbers
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicateNumbers(numbers);
        validateRanges(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw LOTTO_NUMBER_SIZE.getException();
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw DUPLICATE_NUMBERS.getException();
        }
    }

    private void validateRanges(List<Integer> numbers) {
        numbers.forEach(this::validateRange);
    }

    protected void validateRange(int number) {
        if (number < LOTTO_MIN_RANGE || number > LOTTO_MAX_RANGE) {
            throw LOTTO_NUMBER_RANGE.getException();
        }
    }
}
