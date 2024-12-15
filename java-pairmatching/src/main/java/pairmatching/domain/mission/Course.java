package pairmatching.domain.mission;

import static pairmatching.handler.ErrorHandler.INVALID_INPUT;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public static Course findCourse(String name) {
        return Arrays.stream(Course.values())
                .filter(course -> course.name.equals(name.trim()))
                .findFirst()
                .orElseThrow(INVALID_INPUT::getException);
    }

    public static String toInfoString() {
        return Arrays.stream(Course.values())
                .map(course -> course.name)
                .collect(Collectors.joining(" | "));
    }
}

