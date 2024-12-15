package onboarding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Problem1 {
    private static final int PAGES_SIZE = 2;
    private static final int EXCEPTION = -1;
    private static final int BOTH_WIN = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int MIN_PAGES = 1;
    private static final int MAX_PAGES = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            int pobiScore = getMaxScore(pobi);
            int crongScore = getMaxScore(crong);
            return getWinner(pobiScore, crongScore);
        } catch (IllegalArgumentException e) {
            return EXCEPTION;
        }
    }

    private static int getMaxScore(List<Integer> pages) {
        validatePages(pages);
        List<Integer> digits = extractPageDigits(pages);
        int addTotal = digits.stream().mapToInt(Integer::intValue).sum();
        int multiplyTotal = digits.stream().reduce(1, (a, b) -> a * b);
        return Math.max(addTotal, multiplyTotal);
    }

    private static int getWinner(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return POBI_WIN;
        }
        if (pobiScore < crongScore) {
            return CRONG_WIN;
        }
        return BOTH_WIN;
    }

    private static List<Integer> extractPageDigits(List<Integer> pages) {
        return pages.stream()
                .flatMap(page -> Stream.of(String.valueOf(page).split("")))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validatePages(List<Integer> pages) {
        validatePagesSize(pages);
        validatePagesRange(pages);
        validatePagesPair(pages);
        validatePagesOddEven(pages);
    }

    private static void validatePagesSize(List<Integer> pages) {
        if (pages.size() != PAGES_SIZE) {
            throw new IllegalArgumentException("Invalid pages size");
        }
    }

    private static void validatePagesRange(List<Integer> pages) {
        if (pages.stream().allMatch(page -> page < MIN_PAGES || page > MAX_PAGES)) {
            throw new IllegalArgumentException("Invalid pages range");
        }
    }

    private static void validatePagesPair(List<Integer> pages) {
        if (IntStream.range(1, pages.size()).allMatch(i -> pages.get(i) != pages.get(i-1)+1)) {
            throw new IllegalArgumentException("Invalid pages pair");
        }
    }

    private static void validatePagesOddEven(List<Integer> pages) {
        if (pages.getFirst() % 2 != 1 || pages.getLast() % 2 != 0) {
            throw new IllegalArgumentException("Invalid pages odd even");
        }
    }
}