package subway.domain.menu;

import static subway.handler.ErrorHandler.INVALID_INPUT;

import java.util.Arrays;

public enum RouteOption {
    SHORTEST_DISTANCE("1", "최단 거리"),
    SHORTEST_DURATION("2", "최소 시간"),
    BACK_TO_MAIN_MENU("B", "돌아가기");

    private final String key;
    private final String name;

    RouteOption(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public static String toInfoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n## 경로 기준").append("\n");
        for (RouteOption routeOption : RouteOption.values()) {
            sb.append(routeOption.key).append(". ").append(routeOption.name).append("\n");
        }
        return sb.toString();
    }

    public static RouteOption findRouteOption(String key) {
        return Arrays.stream(RouteOption.values())
                .filter(routeOption -> routeOption.key.equals(key))
                .findFirst()
                .orElseThrow(INVALID_INPUT::getException);
    }
}
