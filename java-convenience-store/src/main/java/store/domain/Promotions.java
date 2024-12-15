package store.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class Promotions {
    private final Map<String, Event> promotions;

    public Promotions() {
        promotions = new HashMap<>();
    }

    public Event getEvent(String name) {
        return promotions.getOrDefault(name, null);
    }

    public void addEvent(String name, Event event) {
        if (event.isValidEvent()) {
            promotions.put(name, event);
        }
    }

    public List<Integer> getEventBuyGet(String name) {
        return Optional.ofNullable(getEvent(name))
                .map(Event::getBuyGet)
                .orElse(List.of(1, 0));
    }
}
