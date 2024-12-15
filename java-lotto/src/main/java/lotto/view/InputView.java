package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readPurchaseMoney() {
        String message = "구입금액을 입력해 주세요.";
        return prompt(message);
    }

    public String readWinningNumbers() {
        String message = "\n당첨 번호를 입력해 주세요.";
        return prompt(message);
    }

    public String readBonusNumber() {
        String message = "\n보너스 번호를 입력해 주세요.";
        return prompt(message);
    }

    private String prompt(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
