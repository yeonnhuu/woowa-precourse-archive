package bridge.view;

import bridge.domain.enums.GameOptions;
import bridge.domain.enums.MoveOptions;
import camp.nextstep.edu.missionutils.Console;

// 사용자로부터 입력을 받는 역할을 한다.
public class InputView {

    // 다리의 길이를 입력받는다.
    public String readBridgeSize() {
        String message = "다리의 길이를 입력해주세요.";
        String input = prompt(message);
        System.out.println();
        return input;
    }

    // 사용자가 이동할 칸을 입력받는다.
    public String readMoving() {
        String message = String.format("이동할 칸을 선택해주세요. (위: %s, 아래: %s)", MoveOptions.U.name(), MoveOptions.D.name());
        return prompt(message);
    }

    // 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
    public String readGameCommand() {
        String message = String.format("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)", GameOptions.R.name(), GameOptions.Q.name());
        return prompt(message);
    }

    private String prompt(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
