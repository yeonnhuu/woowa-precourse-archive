package store.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readCartItems() {
        String message = "\n구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])";
        return prompt(message);
    }

    public static String readNonPromotionPurchase(String name, int amount) {
        String message = String.format("%n현재 %s %d개는 프로모션 할인이 적용되지 않습니다. 그래도 구매하시겠습니까? (Y/N)", name, amount);
        return prompt(message);
    }

    public static String readAddFreeProduct(String name, int amount) {
        String message = String.format("%n현재 %s은(는) %d개를 무료로 더 받을 수 있습니다. 추가하시겠습니까? (Y/N)", name, amount);
        return prompt(message);
    }

    public static String readMembershipDiscount() {
        String message = "\n멤버십 할인을 받으시겠습니까? (Y/N)";
        return prompt(message);
    }

    public static String readServiceContinue() {
        String message = "\n감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)";
        return prompt(message);
    }

    private static String prompt(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
