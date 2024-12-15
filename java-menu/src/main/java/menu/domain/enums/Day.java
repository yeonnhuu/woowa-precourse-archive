package menu.domain.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Day {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private final String day;

    Day(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public static List<String> getAllDayNames() {
        return Arrays.stream(Day.values())
                .map(Day::getDay)
                .collect(Collectors.toUnmodifiableList());
    }
}
