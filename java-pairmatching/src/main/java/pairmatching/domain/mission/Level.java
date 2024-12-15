package pairmatching.domain.mission;

import static pairmatching.handler.ErrorHandler.INVALID_INPUT;

import java.util.Arrays;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", List.of("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", List.of("장바구니", "결제", "지하철노선도")),
    LEVEL3("레벨3", List.of()),
    LEVEL4("레벨4", List.of("성능개선", "배포")),
    LEVEL5("레벨5", List.of());

    private final String name;
    private final List<String> tasks;

    Level(String name, List<String> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    // 추가 기능 구현
    public static String toInfoString() {
        StringBuilder sb = new StringBuilder();
        for (Level level: Level.values()) {
            sb.append("\n").append("  - ").append(level.name).append(": ");
            sb.append(String.join(" | ", level.tasks));
        }
        return sb.toString();
    }

    public static Level findLevel(String levelName, String taskName) {
        return Arrays.stream(Level.values())
                .filter(level -> level.name.equals(levelName.trim()))
                .filter(level -> level.tasks.contains(taskName.trim()))
                .findFirst()
                .orElseThrow(INVALID_INPUT::getException);
    }
}

