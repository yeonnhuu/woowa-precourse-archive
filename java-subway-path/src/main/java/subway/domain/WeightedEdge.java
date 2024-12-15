package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import subway.domain.menu.RouteOption;

public class WeightedEdge extends DefaultWeightedEdge {
    private final Weight weight;

    public WeightedEdge(Weight weight) {
        this.weight = weight;
    }

    public int getEdgeWeight(RouteOption routeOption) {
        return weight.getWeight(routeOption);
    }
}

