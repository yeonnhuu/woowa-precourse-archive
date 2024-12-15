package onboarding;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {
    private static final int MUTUAL_FRIEND_POINT = 10;
    private static final int TIMELINE_VISIT_POINT = 1;
    private static final int RECOMMEND_MAX_NUMBER = 5;

    private static final int USER_MIN_LENGTH = 1;
    private static final int USER_MAX_LENGTH = 30;
    private static final int FRIENDS_MIN_NUMBER = 1;
    private static final int FRIENDS_MAX_NUMBER = 10_000;
    private static final int FRIENDS_INFO_SIZE = 2;
    private static final int VISITORS_MIN_NUMBER = 0;
    private static final int VISITORS_MAX_NUMBER = 10_000;
    private static final int ID_MIN_LENGTH = 1;
    private static final int ID_MAX_LENGTH = 30;
    private static final String ID_REGEX = "^[a-z]*$";

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        validate(user, friends, visitors);

        Map<String, Set<String>> friendsMap = buildFriendsMap(friends);
        Map<String, Integer> pointsMap = calculatePoints(user, friendsMap, visitors);
        return findFriendsToRecommend(pointsMap);
    }

    private static Map<String, Set<String>> buildFriendsMap(List<List<String>> friends) {
        Map<String, Set<String>> friendsMap = new HashMap<>();
        for (List<String> friend : friends) {
            friendsMap.computeIfAbsent(friend.getFirst(), k -> new HashSet<>()).add(friend.getLast());
            friendsMap.computeIfAbsent(friend.getLast(), k -> new HashSet<>()).add(friend.getFirst());
        }
        return friendsMap;
    }

    private static Map<String, Integer> calculatePoints(String user,  Map<String, Set<String>>friendsMap, List<String> visitors) {
        Map<String, Integer> pointsMap = new HashMap<>();
        calculateFriendsPoints(user, friendsMap, pointsMap);
        calculateVisitorsPoints(user, friendsMap, visitors, pointsMap);
        return pointsMap;
    }

    private static void calculateFriendsPoints(String user,  Map<String, Set<String>> friendsMap, Map<String, Integer> pointsMap) {
        Set<String> userFriends = friendsMap.get(user);
        for (String candidate: friendsMap.keySet()) {
            if (Objects.equals(candidate, user) || userFriends.contains(candidate)) {
                continue;
            }

            Set<String> candidateFriends = friendsMap.get(candidate);
            for (String candidateFriend: candidateFriends) {
                if (userFriends.contains(candidateFriend)) {
                    pointsMap.put(candidate, pointsMap.getOrDefault(candidate, 0) + MUTUAL_FRIEND_POINT);
                }
            }
        }
    }

    private static void calculateVisitorsPoints(String user, Map<String, Set<String>> friendsMap, List<String> visitors, Map<String, Integer> pointsMap) {
        Set<String> userFriends = friendsMap.get(user);
        for (String candidate: visitors) {
            if (Objects.equals(candidate, user) || userFriends.contains(candidate)) {
                continue;
            }
            pointsMap.put(candidate, pointsMap.getOrDefault(candidate, 0) + TIMELINE_VISIT_POINT);
        }
    }

    private static List<String> findFriendsToRecommend(Map<String, Integer> pointsMap) {
        List<Map.Entry<String, Integer>> sortedFriends = pointsMap.entrySet().stream()
                .sorted(Comparator
                        .comparing(Map.Entry<String, Integer>::getValue, Comparator.reverseOrder())
                        .thenComparing(Entry::getKey)
                )
                .limit(RECOMMEND_MAX_NUMBER)
                .toList();

        return sortedFriends.stream()
                .map(Entry::getKey)
                .collect(Collectors.toList());

    }

    private static void validate(String user, List<List<String>> friends, List<String> visitors) {
        validateUser(user);
        validateFriends(friends);
        validateVisitors(visitors);
    }

    private static void validateUser(String user) {
        validateUserLength(user);
    }

    private static void validateFriends(List<List<String>> friends) {
        validateFriendsNumber(friends);
        validateFriendsInfoSize(friends);
        validateFriendsID(friends);
    }

    private static void validateVisitors(List<String> visitors) {
        validateVisitorsNumber(visitors);
        validateVisitorsID(visitors);
    }

    private static void validateUserLength(String user) {
        if (user.length() < USER_MIN_LENGTH || user.length() > USER_MAX_LENGTH) {
            throw new IllegalArgumentException("User's length must be between " + USER_MIN_LENGTH + " and " + USER_MAX_LENGTH);
        }
    }

    private static void validateFriendsNumber(List<List<String>> friends) {
        if (friends.size() < FRIENDS_MIN_NUMBER || friends.size() > FRIENDS_MAX_NUMBER) {
            throw new IllegalArgumentException("Number of friends must be between " + FRIENDS_MIN_NUMBER + " and " + FRIENDS_MAX_NUMBER);
        }
    }

    private static void validateFriendsInfoSize(List<List<String>> friends) {
        friends.forEach(friend -> {
            if (friend.size() != FRIENDS_INFO_SIZE) {
                throw new IllegalArgumentException("Friends info must contain exactly " + FRIENDS_INFO_SIZE + " elements");
            }
        });
    }

    private static void validateFriendsID(List<List<String>> friends) {
        friends.forEach(friend -> {
            friend.forEach(id -> {
                validateID(id);
            });
        });
    }

    private static void validateVisitorsNumber(List<String> visitors) {
        if (visitors.size() < VISITORS_MIN_NUMBER || visitors.size() > VISITORS_MAX_NUMBER) {
            throw new IllegalArgumentException("Number of visitors must be between " + VISITORS_MIN_NUMBER + " and " + VISITORS_MAX_NUMBER);
        }
    }

    private static void validateVisitorsID(List<String> visitors) {
        visitors.forEach(id -> {
            validateID(id);
        });
    }

    private static void validateID(String id) {
        validateIDLength(id);
        validateIDLetter(id);
    }

    private static void validateIDLength(String id) {
        if (id.length() < ID_MIN_LENGTH || id.length() > ID_MAX_LENGTH) {
            throw new IllegalArgumentException("ID length must be between " + ID_MIN_LENGTH + " and " + ID_MAX_LENGTH);
        }
    }

    private static void validateIDLetter(String id) {
        if (!id.matches(ID_REGEX)) {
            throw new IllegalArgumentException("ID must match " + ID_REGEX);
        }
    }
}
