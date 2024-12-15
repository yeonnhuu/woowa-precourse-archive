package subway.view;

import static subway.util.Constants.DISTANCE_UNIT;
import static subway.util.Constants.DURATION_UNIT;

import java.util.List;

public class OutputView {
    private static final String INFO_PREFIX = "[INFO] ";

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printViewResult(int distance, int duration, List<String> stations) {
        System.out.println("\n## 조회 결과");
        printResultWeight(distance, duration);
        printResultStations(stations);
    }

    private void printResultWeight(int distance, int duration) {
        printAsInfo("---");
        printAsInfo(String.format("총 거리: %d%s", distance, DISTANCE_UNIT));
        printAsInfo(String.format("총 소요 시간: %d%s", duration, DURATION_UNIT));
    }

    private void printResultStations(List<String> stations) {
        printAsInfo("---");
        for (String station : stations) {
            printAsInfo(station);
        }
        System.out.println();
    }

    private void printAsInfo(String message) {
        System.out.println(INFO_PREFIX + message);
    }
}
