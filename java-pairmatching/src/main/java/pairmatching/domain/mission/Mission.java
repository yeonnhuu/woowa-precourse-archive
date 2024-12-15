package pairmatching.domain.mission;

import static pairmatching.handler.ErrorHandler.INVALID_INPUT;

public class Mission {
    private final String course;
    private final String level;

    public Mission(String course, String level) {
        this.course = course;
        this.level = level;
    }

    public Course getCourse() {
        return Course.valueOf(course);
    }

    public String codeMission() {
        return course + "-" + level;
    }

    public static Mission findMission(String properties) {
        String[] props = validateAndParse(properties);
        Course course = Course.findCourse(props[0]);
        Level level = Level.findLevel(props[1], props[2]);
        return new Mission(course.name(), level.name());
    }

    private static String[] validateAndParse(String properties) {
        String[] props = properties.split(",");
        if (props.length != 3) {
            throw INVALID_INPUT.getException();
        }
        return props;
    }
}
