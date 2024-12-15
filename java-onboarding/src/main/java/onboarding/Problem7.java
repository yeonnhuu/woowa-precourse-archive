package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {
    private static final int MUTUAL_FRIEND_POINT = 10;
    private static final int TIMELINE_VISIT_POINT = 1;
    private static final int RECOMMEND_NUMBER = 5;
    private static final int ID_LENGTH_MIN = 1;
    private static final int ID_LENGTH_MAX = 30;
    private static final int FRIENDS_NUMBER_MIN = 1;
    private static final int FRIENDS_NUMBER_MAX = 10_000;
    private static final int VISITORS_NUMBER_MIN = 0;
    private static final int VISITORS_NUMBER_MAX = 10_000;
    private static final String ID_REGEX = "^[a-z]+$";

    private static Map<String, Integer> points;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        validate(user, friends, visitors);
        calculatePoints(user, friends, visitors);
        sortPoints();
        return getFriendRecommendation();
    }

    private static void calculatePoints(String user, List<List<String>> friends, List<String> visitors) {
        points = new HashMap<>();
        Map<String, Set<String>> relations = buildRelationMap(friends);
        calculateFriendsPoints(user, relations);
        calculateVisitorsPoints(user, visitors, relations);
    }

    private static Map<String, Set<String>> buildRelationMap(List<List<String>> friends) {
        Map<String, Set<String>> relations = new HashMap<>();
        for (List<String> relation : friends) {
            String id1 = relation.getFirst();
            String id2 = relation.getLast();
            relations.computeIfAbsent(id1, k -> new HashSet<>()).add(id2);
            relations.computeIfAbsent(id2, k -> new HashSet<>()).add(id1);
        }
        return relations;
    }

    private static void calculateFriendsPoints(String user, Map<String, Set<String>> relations) {
        Set<String> userFriends = relations.getOrDefault(user, Collections.emptySet());
        for (String id : relations.keySet()) {
            if (id.equals(user) || userFriends.contains(id)) {
                continue;
            }
            if (userFriends.stream().anyMatch(relations.getOrDefault(id, Collections.emptySet())::contains)) {
                points.put(id, points.getOrDefault(id, 0) + MUTUAL_FRIEND_POINT);
            }
        }
    }

    private static void calculateVisitorsPoints(String user, List<String> visitors, Map<String, Set<String>> relations) {
        Set<String> userFriends = relations.getOrDefault(user, Collections.emptySet());
        for (String id : visitors) {
            if (!userFriends.contains(id)) {
                points.put(id, points.getOrDefault(id, 0) + TIMELINE_VISIT_POINT);
            }
        }
    }

    private static void sortPoints() {
        List<Map.Entry<String, Integer>> entries = getSortedEntries();
        points = entries.stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    private static List<Map.Entry<String, Integer>> getSortedEntries() {
        return points.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int valueComparison = e2.getValue().compareTo(e1.getValue());
                    return valueComparison != 0 ? valueComparison : e1.getKey().compareTo(e2.getKey());
                })
                .collect(Collectors.toList());
    }

    private static List<String> getFriendRecommendation() {
        int recommendNumber = Math.min(RECOMMEND_NUMBER, points.size());
        return points.keySet()
                .stream()
                .limit(recommendNumber)
                .toList();
    }

    private static void validate(String user, List<List<String>> friends, List<String> visitors) {
        validateUser(user);
        validateFriends(friends);
        validateVisitors(visitors);
    }

    private static void validateUser(String user) {
        validateID(user);
    }

    private static void validateFriends(List<List<String>> friends) {
        validateFriendsNumber(friends);
        validateFriendsID(friends);
    }

    private static void validateVisitors(List<String> visitors) {
        validateVisitorsNumber(visitors);
        validateVisitorsID(visitors);
    }

    private static void validateFriendsNumber(List<List<String>> friends) {
        if (friends.size() < FRIENDS_NUMBER_MIN || friends.size() > FRIENDS_NUMBER_MAX) {
            throw new IllegalArgumentException("Friends number is invalid");
        }
    }

    private static void validateFriendsID(List<List<String>> friends) {
        for (List<String> friendLst : friends) {
            validateID(friendLst.getFirst());
            validateID(friendLst.getLast());
        }
    }

    private static void validateVisitorsNumber(List<String> visitors) {
        if (visitors.size() < VISITORS_NUMBER_MIN || visitors.size() > VISITORS_NUMBER_MAX) {
            throw new IllegalArgumentException("Visitors number is invalid");
        }
    }

    private static void validateVisitorsID(List<String> visitors) {
        for (String visitor : visitors) {
            validateID(visitor);
        }
    }

    private static void validateID(String id) {
        validateIDLength(id);
        validateIDLetter(id);
    }

    private static void validateIDLength(String id) {
        if (id.length() < ID_LENGTH_MIN || id.length() > ID_LENGTH_MAX) {
            throw new IllegalArgumentException("ID length is invalid");
        }
    }

    private static void validateIDLetter(String id) {
        if (!id.matches(ID_REGEX)) {
            throw new IllegalArgumentException("ID letter is not valid");
        }
    }
}
