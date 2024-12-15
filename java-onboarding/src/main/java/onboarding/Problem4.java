package onboarding;

public class Problem4 {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1000;

    public static String solution(String word) {
        validate(word);

        StringBuilder answer = new StringBuilder();
        for (char c : word.toCharArray()) {
            Character letter = convertLetter(c);
            answer.append(letter);
        }
        return answer.toString();
    }

    private static char convertLetter(char c) {
        if (Character.isUpperCase(c)) {
            return (char)('Z'-(c-'A'));
        } else if (Character.isLowerCase(c)) {
            return (char)('z'-(c-'a'));
        }
        return c;
    }

    private static void validate(String word) {
        validateLength(word);
    }

    private static void validateLength(String word) {
        if (word.length() < MIN_LENGTH || word.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Invalid word length");
        }
    }
}
