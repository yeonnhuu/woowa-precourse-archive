package pairmatching.handler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class CrewHandler {

    public List<String> readCrewNames(String courseType) throws IOException {
        Path crewFilepath = Path.of("src/main/resources/" + courseType + "-crew.md");
        List<String> allLines = Files.readAllLines(crewFilepath);

        return allLines.stream()
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .toList();
    }
}
