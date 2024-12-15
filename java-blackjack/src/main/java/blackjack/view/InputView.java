package blackjack.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readPlayerNames() {
        String message = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
        return prompt(message);
    }

    public String readPlayerBettingMoney(String playerName) {
        String message = String.format("\n%s의 배팅 금액은?", playerName);
        return prompt(message);
    }

    public String readPlayerHit(String playerName) {
        String message = String.format("\n%s는 한 장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)", playerName);
        return prompt(message);
    }

    private String prompt(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
