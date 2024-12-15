package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readStringToCalculate() {
        String message = "덧셈할 문자열을 입력해 주세요.";
        return prompt(message);
    }

    private String prompt(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
