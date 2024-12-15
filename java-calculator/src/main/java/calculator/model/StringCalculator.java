package calculator.model;

import static calculator.handler.ErrorHandler.INVALID_INPUT;
import static calculator.handler.ErrorHandler.INVALID_NUMBER;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");

    public int calculateSum(String expression) {
        String[] tokens = parseInput(expression);
        int sum = 0;
        for (String token : tokens) {
            int number = parseNumber(token);
            validateNumber(number);
            sum += number;
        }
        return sum;
    }

    private String[] parseInput(String expression) {
        if (expression == null || expression.isEmpty()) {
            return new String[0];
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(expression);
        if (matcher.matches()) {
            String customDelimiter = Pattern.quote(matcher.group(1));
            return matcher.group(2).split(DEFAULT_DELIMITERS + "|" + customDelimiter);
        }
        return expression.split(DEFAULT_DELIMITERS);
    }

    private int parseNumber(String token) {
        try {
            return Integer.parseInt(token.trim());
        } catch (NumberFormatException e) {
            throw INVALID_INPUT.getException();
        }
    }

    private void validateNumber(int number) {
        if (number <= 0) {
            throw INVALID_NUMBER.getException();
        }
    }
}
