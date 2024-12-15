package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readGuess() {
        String message = "숫자를 입력해주세요 : ";
        return prompt(message);
    }

    public String readGameContinue() {
        String message = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
        return prompt(message);
    }

    private String prompt(String message) {
        System.out.print(message);
        return Console.readLine();
    }
}
