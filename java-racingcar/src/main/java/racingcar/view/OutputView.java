package racingcar.view;

import java.util.List;

public class OutputView {

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printRacingResult() {
        System.out.println("실행 결과");
    }

    public void printRacingProcess(String process) {
        System.out.println(process);
    }

    public void printRacingWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
