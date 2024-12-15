package subway.view;

import java.util.Scanner;
import subway.domain.menu.MainOption;
import subway.domain.menu.RouteOption;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readMainOption() {
        String message = MainOption.toInfoString() + readOption();
        return prompt(message);
    }

    public String readRouteOption() {
        String message = RouteOption.toInfoString() + readOption();
        return prompt(message);
    }

    private String readOption() {
        return "\n## 원하는 기능을 선택하세요.";
    }

    public String readStartStation() {
        String message = "\n## 출발역을 입력하세요.";
        return prompt(message);
    }

    public String readFinishStation() {
        String message = "\n## 도착역을 입력하세요.";
        return prompt(message);
    }

    private String prompt(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
