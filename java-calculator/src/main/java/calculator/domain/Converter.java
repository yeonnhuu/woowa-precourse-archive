package calculator.domain;

import java.util.List;

public class Converter {

    public List<Integer> stringToInteger(List<String> numbers) {
        return numbers.stream()
                    .map(this::parseNumber)
                    .toList();
    }

    private int parseNumber(String number) {
        try {
            return parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Number format error.");
        }
    }

    private int parseInt(String number) {
        int parsedInt = Integer.parseInt(number);
        if (parsedInt <= 0) {
            throw new IllegalArgumentException("Number positive error.");
        }
        return parsedInt;
    }
}
