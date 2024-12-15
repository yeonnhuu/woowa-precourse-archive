package onboarding;

public class Problem3 {
    private static final int BASE = 10;
    private static final int CLAP_DIVISOR = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10000;

    public static int solution(int number) {
        validate(number);
        int totalClaps = 0;
        for (int num = MIN_NUMBER; num <= number; num++) {
            totalClaps += countClaps(num);
        }
        return totalClaps;
    }

    private static int countClaps(int number) {
        return (int) String.valueOf(number)
                .chars()
                .map(Character::getNumericValue)
                .filter(Problem3::isClap)
                .count();
    }

    private static boolean isClap(int digit) {
        return digit != 0 && digit % CLAP_DIVISOR == 0;
    }

    private static void validate(int number) {
        validateNumberRange(number);
    }

    private static void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("Invalid number range");
        }
    }
}
