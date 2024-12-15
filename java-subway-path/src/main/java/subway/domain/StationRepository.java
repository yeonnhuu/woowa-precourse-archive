package subway.domain;

import static subway.handler.ErrorHandler.INVALID_STATION;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private final List<Station> stations;

    public StationRepository() {
        this.stations = new ArrayList<>();
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public Station findStationByName(String name) {
        return stations.stream()
                .filter(station -> Objects.equals(station.getName(), name))
                .findFirst()
                .orElseThrow(INVALID_STATION::getException);
    }

    public Station findAndAddStationByName(String name) {
        if (!hasStation(name)) {
            addStation(new Station(name));
        }
        return findStationByName(name);
    }

    private boolean hasStation(String name) {
        return stations.stream()
                .anyMatch(station -> station.getName().equals(name));
    }
}
