package subway.domain;

import static subway.handler.ErrorHandler.DISCONNECTED_STATIONS;

import java.io.IOException;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.menu.RouteOption;
import subway.util.PathRegisterar;

public class PathRepository {
    private final WeightedMultigraph<Station, WeightedEdge> graph;

    public PathRepository() throws IOException {
        PathRegisterar pathRegisterar = new PathRegisterar();
        this.graph = pathRegisterar.registerPath();
    }

    public GraphPath<Station, WeightedEdge> calculateShortestPath(Station source, Station target, RouteOption routeOption) {
        graph.edgeSet().forEach(edge ->
                graph.setEdgeWeight(edge, edge.getEdgeWeight(routeOption))
        );

        DijkstraShortestPath<Station, WeightedEdge> dijkstra = new DijkstraShortestPath<>(graph);
        GraphPath<Station, WeightedEdge> path = dijkstra.getPath(source, target);
        validate(path);
        return path;
    }

    private void validate(GraphPath<Station, WeightedEdge> path) {
        if (path == null) {
            throw DISCONNECTED_STATIONS.getException();
        }
    }
}

