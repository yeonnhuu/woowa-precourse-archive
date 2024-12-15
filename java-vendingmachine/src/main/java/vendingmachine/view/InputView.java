package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readVendingMoney() {
        String message = "자판기가 보유하고 있는 금액을 입력해 주세요.";
        return prompt(message);
    }

    public String readVendingProducts() {
        String message = "\n상품명과 가격, 수량을 입력해 주세요.";
        return prompt(message);
    }

    public String readPurchaseMoney() {
        String message = "\n투입 금액을 입력해 주세요.";
        return prompt(message);
    }

    public String readPurchaseProduct() {
        String message = "구매할 상품명을 입력해 주세요.";
        return prompt(message);
    }

    private String prompt(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
