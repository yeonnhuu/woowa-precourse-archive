package onboarding;

import java.util.regex.Pattern;

public class Problem2 {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1000;
    private static final String LOWERCASE_REGEX = "[a-z]+";
    private static final String DUPLICATE_REGEX = "([a-z])\\1+";
    private static final Pattern DUPLICATE_PATTERN = Pattern.compile(DUPLICATE_REGEX);

    public static String solution(String cryptogram) {
        validate(cryptogram);
        String previous;
        do {
            previous = cryptogram;
            cryptogram = DUPLICATE_PATTERN.matcher(cryptogram).replaceAll("");
        } while (!cryptogram.equals(previous));
        return cryptogram;
    }

    private static void validate(String cryptogram) {
        validateLength(cryptogram);
        validateLowerCase(cryptogram);
    }

    private static void validateLength(String cryptogram) {
        if (cryptogram.length() < MIN_LENGTH || cryptogram.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Invalid cryptogram length");
        }
    }

    private static void validateLowerCase(String cryptogram) {
        if (!cryptogram.matches(LOWERCASE_REGEX)) {
            throw new IllegalArgumentException("Invalid cryptogram lower case");
        }
    }
}
