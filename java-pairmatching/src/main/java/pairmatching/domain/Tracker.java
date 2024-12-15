package pairmatching.domain;

import static pairmatching.handler.ErrorHandler.UNAVAILABLE_VIEW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {
    private final Map<String, List<Pairs>> tracker;

    public Tracker() {
        this.tracker = new HashMap<>();
    }

    public void initialize() {
        this.tracker.clear();
    }

    public Pairs searchPairs(String mission) {
        if (!this.tracker.containsKey(mission)) {
            throw UNAVAILABLE_VIEW.getException();
        }
        return this.tracker.get(mission).getLast();
    }

    public boolean addedPairs(String mission, Pairs pairs) {
        boolean ableToAdd = isAbleToAdd(mission, pairs);
        if (ableToAdd) {
            this.tracker.get(mission).add(pairs);
        }
        return ableToAdd;
    }

    private boolean isAbleToAdd(String mission, Pairs pairs) {
        List<Pairs> allTrackerPairs =  this.tracker.computeIfAbsent(mission, k -> new ArrayList<>());
        for (Pairs trackerPairs : allTrackerPairs) {
            if (!pairs.isPairable(trackerPairs)) {
                return false;
            }
        }
        return true;
    }
}
