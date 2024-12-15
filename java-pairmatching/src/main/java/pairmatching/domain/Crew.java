package pairmatching.domain;

import pairmatching.domain.mission.Course;

public class Crew {
    private final Course course;
    private final String name;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public boolean equals(Course otherCourse) {
        return this.course.compareTo(otherCourse) == 0;
    }

    public String getName() {
        return name;
    }
}
