package baseball.domain;

import baseball.validator.NumbersValidator;
import java.util.List;

public class Converter {
    private final NumbersValidator numbersValidator;

    public Converter() {
        numbersValidator = new NumbersValidator();
    }

    public List<Integer> toNumbers(String input) {
        List<Integer> numbers = input.chars()
                        .mapToObj(letter -> parseInt((char)letter))
                        .toList();
        numbersValidator.validate(numbers);
        return numbers;
    }

    private int parseInt(char letter) {
        try {
            return Integer.parseInt(String.valueOf(letter));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Number format error.");
        }
    }
}
