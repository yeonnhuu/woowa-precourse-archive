package lotto;

import static lotto.handler.ErrorHandler.INVALID_LOTTO_DISTINCT;
import static lotto.handler.ErrorHandler.INVALID_LOTTO_RANGE;
import static lotto.handler.ErrorHandler.INVALID_LOTTO_SIZE;
import static lotto.util.Constants.LOTTO_MAX_RANGE;
import static lotto.util.Constants.LOTTO_MIN_RANGE;
import static lotto.util.Constants.LOTTO_SIZE;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String toString() {
        return numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRanges(numbers);
        validateDistinct(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw INVALID_LOTTO_SIZE.getException();
        }
    }

    private void validateRanges(List<Integer> numbers) {
        for (int number: numbers) {
            validateRange(number);
        }
    }

    private void validateDistinct(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw INVALID_LOTTO_DISTINCT.getException();
        }
    }

    protected void validateRange(int number) {
        if (number < LOTTO_MIN_RANGE || number > LOTTO_MAX_RANGE) {
            throw INVALID_LOTTO_RANGE.getException();
        }
    }
}
