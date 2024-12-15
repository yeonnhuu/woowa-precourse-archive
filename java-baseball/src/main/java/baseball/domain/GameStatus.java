package baseball.domain;

import static baseball.util.GameConstants.GAME_NUMBERS_SIZE;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public enum GameStatus {
    BALL("볼"),
    STRIKE("스트라이크");

    private final String name;
    private static Map<GameStatus, Integer> statusMap;

    GameStatus(String name) {
        this.name = name;
    }

    public static void initializeStatus() {
        statusMap = new TreeMap<>();
        for (GameStatus status : GameStatus.values()) {
            statusMap.put(status, 0);
        }
    }

    public static String processGuess(List<Integer> guess, List<Integer> answer) {
        initializeStatus();
        for (int i = 0; i < guess.size(); i++) {
            if (answer.contains(guess.get(i))) {
                checkStatus(guess.get(i), answer.get(i));
            }
        }
        return buildResult();
    }

    private static void checkStatus(int guessNumber, int answerNumber) {
        if (guessNumber == answerNumber) {
            statusMap.put(GameStatus.STRIKE, statusMap.get(GameStatus.STRIKE) + 1);
            return;
        }
        statusMap.put(GameStatus.BALL, statusMap.get(GameStatus.BALL) + 1);
    }

    private static String buildResult() {
        StringBuilder sb = processBallStrike();
        if (sb.isEmpty()) {
            return "낫싱";
        }
        return sb.toString().trim();
    }

    private static StringBuilder processBallStrike() {
        StringBuilder sb = new StringBuilder();
        for (Entry<GameStatus, Integer> entry : statusMap.entrySet()) {
            int statusCount = entry.getValue();
            if (statusCount > 0) {
                sb.append(statusCount).append(entry.getKey().toKorean()).append(" ");
            }
        }
        return sb;
    }

    public static boolean isAllStrike() {
        return statusMap.get(GameStatus.STRIKE).equals(GAME_NUMBERS_SIZE);
    }

    private String toKorean() {
        return name;
    }
}
