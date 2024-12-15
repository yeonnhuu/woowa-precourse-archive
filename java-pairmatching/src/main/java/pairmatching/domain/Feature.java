package pairmatching.domain;

import static pairmatching.handler.ErrorHandler.INVALID_INPUT;

import java.util.Arrays;

public enum Feature {
    MATCH("1"),
    VIEW("2"),
    INITIALIZE("3"),
    QUIT("Q");

    private final String name;

    Feature(String name) {
        this.name = name;
    }

    public static Feature findFeature(String name) {
        return Arrays.stream(Feature.values())
                .filter(feature -> feature.name.equals(name.trim()))
                .findFirst()
                .orElseThrow(INVALID_INPUT::getException);
    }
}
