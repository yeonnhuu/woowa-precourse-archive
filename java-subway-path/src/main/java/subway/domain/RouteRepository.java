package subway.domain;

import static subway.handler.ErrorHandler.IDENTICAL_STATIONS;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.jgrapht.GraphPath;
import subway.domain.menu.RouteOption;

public class RouteRepository {
    private final PathRepository pathRepository;
    private GraphPath<Station, WeightedEdge> path;

    public RouteRepository() throws IOException {
        this.pathRepository = new PathRepository();
    }

    public void calculateShortestRoute(Station source, Station target, RouteOption routeOption) {
        validate(source, target);
        this.path = pathRepository.calculateShortestPath(source, target, routeOption);
    }

    public int findRouteWeight(RouteOption routeOption) {
        return (int) path.getEdgeList().stream()
                .mapToDouble(edge -> edge.getEdgeWeight(routeOption))
                .sum();
    }

    public List<String> findRouteStations() {
        List<Station> stations = path.getVertexList();
        return stations.stream()
                .map(Station::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validate(Station source, Station target) {
        if (source.equals(target)) {
            throw IDENTICAL_STATIONS.getException();
        }
    }
}
