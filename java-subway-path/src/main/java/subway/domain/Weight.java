package subway.domain;

import subway.domain.menu.RouteOption;

public class Weight {
    private final int distance;
    private final int duration;

    public Weight(int distance, int duration) {
        this.distance = distance;
        this.duration = duration;
    }

    public int getWeight(RouteOption routeOption) {
        if (routeOption == RouteOption.SHORTEST_DISTANCE) {
            return distance;
        }
        if (routeOption == RouteOption.SHORTEST_DURATION) {
            return duration;
        }
        return 0;
    }
}

