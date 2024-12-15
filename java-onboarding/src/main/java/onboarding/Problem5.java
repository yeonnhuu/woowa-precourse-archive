package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int MIN_MONEY = 1;
    private static final int MAX_MONEY = 1_000_000;
    private static final List<Integer> units = List.of(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        validate(money);
        List<Integer> answer = new ArrayList<>(Collections.emptyList());
        for (int unit : units) {
            int count = money / unit;
            answer.add(count);
            money %= unit;
        }
        return answer;
    }

    private static void validate(int money) {
        validateRange(money);
    }

    private static void validateRange(int money) {
        if (money < MIN_MONEY || money > MAX_MONEY) {
            throw new IllegalArgumentException("Invalid money range");
        }
    }
}

