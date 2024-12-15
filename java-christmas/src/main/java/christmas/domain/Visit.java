package christmas.domain;

import static christmas.constants.VisitConstants.*;

import java.time.LocalDate;

public class Visit {
    private final int day;

    public Visit(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public boolean isBeforeChristmas() {
        return day <= CHRISTMAS_DAY;
    }

    public boolean isWeekend() {
        return WEEKEND_VALUES.contains(getDayOfWeekValue());
    }

    public boolean isSpecialDay() {
        return SPECIAL_DAYS.contains(day);
    }

    public int getDayOfWeekValue() {
        LocalDate date = LocalDate.of(CURRENT_YEAR, CURRENT_MONTH, day);
        return date.getDayOfWeek().getValue();
    }
}
