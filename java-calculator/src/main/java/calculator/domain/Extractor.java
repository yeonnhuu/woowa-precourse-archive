package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {
    private final List<String> INITIAL_DELIMITERS = List.of(",", ":");

    public List<String> extractDelimiters(String input) {
        List<String> delimiters = new ArrayList<>(INITIAL_DELIMITERS);
        Matcher matcher = buildCustomDelimiterMatcher(input);
        if (matcher.find()) {
            delimiters.add(matcher.group(1));
        }
        return delimiters;
    }

    public String extractInput(String input) {
        Matcher matcher = buildCustomDelimiterMatcher(input);
        if (matcher.find()) {
            return matcher.group(2);
        }
        return input;
    }

    private Matcher buildCustomDelimiterMatcher(String input) {
        String customRegex = "^//([^\\\\n]+)\\\\n(.*)";
        return Pattern.compile(customRegex).matcher(input);
    }
}
