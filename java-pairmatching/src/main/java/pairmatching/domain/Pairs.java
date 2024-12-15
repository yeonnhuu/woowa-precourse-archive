package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pairs {
    private final List<Pair> pairs;

    public Pairs() {
        this.pairs = new ArrayList<>();
    }

    public void addPair(List<String> names) {
        Pair pair = new Pair(names);
        this.pairs.add(pair);
    }

    public boolean isPairable(Pairs otherPairs) {
        for (Pair pair : pairs) {
            for (Pair otherPair : otherPairs.pairs) {
                if (!pair.isPairable(otherPair)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String toInfoString() {
        StringBuilder sb = new StringBuilder();
        for (Pair pair : pairs) {
            sb.append(pair.toInfoString()).append("\n");
        }
        return sb.toString();
    }
}
