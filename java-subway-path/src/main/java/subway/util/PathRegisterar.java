package subway.util;

import static subway.util.Constants.DISTANCE_UNIT;
import static subway.util.Constants.DURATION_UNIT;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.Weight;
import subway.domain.WeightedEdge;

public class PathRegisterar {
    private final WeightedMultigraph<Station, WeightedEdge> graph;

    public PathRegisterar() {
        graph = new WeightedMultigraph<>(WeightedEdge.class);
    }

    public WeightedMultigraph<Station, WeightedEdge> registerPath() throws IOException {
        Path path = Path.of("src/main/resources/subway-path.md");
        List<String> allLines = Files.readAllLines(path);
        for (String line : allLines) {
            parsePath(line.split(":"));
        }
        return graph;
    }

    private void parsePath(String[] route) {
        String[] data = route[1].split("-");
        for (int i = 0; i < data.length-1; i+=2) {
            Station v1 = StationRepository.findAndAddStationByName(data[i].trim());
            Station v2 = StationRepository.findAndAddStationByName(data[i+2].trim());
            String weight = data[i+1].trim();
            String[] w = weight.substring(1, weight.length() - 1).trim().split("/");
            expandGraph(v1, v2, w);
        }
    }

    private void expandGraph(Station v1, Station v2, String[] w) {
        String[] w1 = w[0].split(DISTANCE_UNIT);
        String[] w2 = w[1].split(DURATION_UNIT);
        int distance = Integer.parseInt(w1[0].trim());
        int duration = Integer.parseInt(w2[0].trim());

        graph.addVertex(v1);
        graph.addVertex(v2);
        WeightedEdge edge = new WeightedEdge(new Weight(distance, duration));
        graph.addEdge(v1, v2, edge);
    }
}
