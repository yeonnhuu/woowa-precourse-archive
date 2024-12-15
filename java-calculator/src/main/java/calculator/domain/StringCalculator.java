package calculator.domain;

import java.util.List;

public class StringCalculator {
    private final Converter converter;

    public StringCalculator() {
        converter = new Converter();
    }

    public int sum(List<String> strNumbers) {
        List<Integer> numbers = converter.stringToInteger(strNumbers);
        return numbers.stream()
                .mapToInt(n -> n)
                .sum();
    }
}
