package christmas.domain;

import java.util.Comparator;
import java.util.stream.Stream;

public enum Badge {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000),
    NONE("없음", 0);

    private final String name;
    private final int value;

    Badge(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public static Badge getBadge(int amount) {
        return Stream.of(Badge.values())
                .filter(badge -> amount >= badge.value)
                .max(Comparator.comparingInt(Badge::getValue))
                .orElse(Badge.NONE);
    }
}
