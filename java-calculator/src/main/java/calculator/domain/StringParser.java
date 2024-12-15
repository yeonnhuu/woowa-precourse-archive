package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringParser {
    private final Extractor extractor;

    public StringParser() {
        extractor = new Extractor();
    }

    public List<String> parse(String input) {
        List<String> parsedDelimiters = extractor.extractDelimiters(input);
        String parsedInput = extractor.extractInput(input);
        return split(parsedInput, parsedDelimiters);
    }

    private List<String> split(String input, List<String> delimiters) {
        String delimiterRegex = buildDelimiterRegex(delimiters);
        return Arrays.stream(input.split(delimiterRegex))
                .toList();
    }

    private String buildDelimiterRegex(List<String> delimiters) {
        return delimiters.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }
}
