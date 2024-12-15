package pairmatching.domain;

import java.util.List;

public class Pair {
    private final List<String> pair;

    public Pair(List<String> pair) {
        this.pair = pair;
    }

    private boolean hasName(String name) {
        return pair.contains(name);
    }

    public boolean isPairable(Pair otherPair) {
        int count = (int) pair.stream()
                .filter(otherPair::hasName)
                .count();
        return count < 2;
    }

    public String toInfoString() {
        return String.join(" : ", pair);
    }
}
