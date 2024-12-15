package pairmatching.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.mission.Course;
import pairmatching.domain.mission.Mission;
import pairmatching.handler.CrewHandler;

public class Crews {
    private final CrewHandler crewHandler = new CrewHandler();
    private final List<Crew> crews;

    public Crews() throws IOException {
        this.crews = registerCrews();
    }

    public List<Crew> registerCrews() throws IOException {
        List<Crew> crews = new ArrayList<>();
        for (Course course : Course.values()) {
            List<String> crewNames = crewHandler.readCrewNames(course.name().toLowerCase());
            crewNames.forEach(name -> {crews.add(new Crew(course, name));});
        }
        return crews;
    }

    public List<String> filterCrewNames(Mission mission) {
        return crews.stream()
                .filter(crew -> crew.equals(mission.getCourse()))
                .map(Crew::getName)
                .toList();
    }
}
