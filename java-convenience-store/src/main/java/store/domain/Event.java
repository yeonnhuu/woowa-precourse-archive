package store.domain;

import camp.nextstep.edu.missionutils.DateTimes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Event {
    private final int buy;
    private final int get;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public Event(int buy, int get, LocalDate startDate, LocalDate endDate) {
        this.buy = buy;
        this.get = get;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean isValidEvent() {
        LocalDate currentDate = DateTimes.now().toLocalDate();
        return !currentDate.isBefore(startDate) && !currentDate.isAfter(endDate);
    }

    public List<Integer> getBuyGet() {
        return Stream.of(buy, get).toList();
    }
}
