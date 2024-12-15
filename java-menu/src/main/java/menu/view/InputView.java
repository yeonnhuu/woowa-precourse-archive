package menu.view;

import camp.nextstep.edu.missionutils.Console;

import static menu.util.Constants.INPUT_DELIMITER;

import java.util.List;

public class InputView {

    public List<String> readCoachNames() {
        String message = "\n코치의 이름을 입력해 주세요. (, 로 구분)";
        return List.of(prompt(message).split(INPUT_DELIMITER));
    }

    public List<String> readAvoidingMenus(String name) {
        String message = String.format("\n%s(이)가 못 먹는 메뉴를 입력해 주세요.", name);
        return List.of(prompt(message).split(INPUT_DELIMITER));
    }

    private String prompt(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
