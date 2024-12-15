package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readVisit() {
        String message = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
        return prompt(message);
    }

    public String readOrders() {
        String message = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
        return prompt(message);
    }

    private String prompt(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}