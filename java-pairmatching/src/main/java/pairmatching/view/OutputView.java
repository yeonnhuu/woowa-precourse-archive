package pairmatching.view;

import pairmatching.domain.mission.Course;
import pairmatching.domain.mission.Level;
import pairmatching.domain.Pairs;

public class OutputView {

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printServiceInfo() {
        String info = "\n#############################################\n"
                + "과정: " + Course.toInfoString() + "\n"
                + "미션:" + Level.toInfoString() + "\n"
                + "#############################################";
        System.out.print(info);
    }

    public void printPairMatchingResult(Pairs pairs) {
        System.out.println("\n페어 매칭 결과입니다.");
        System.out.println(pairs.toInfoString());
    }

    public void printTrackerInitialize() {
        System.out.println("\n초기화 되었습니다.\n");
    }
}
