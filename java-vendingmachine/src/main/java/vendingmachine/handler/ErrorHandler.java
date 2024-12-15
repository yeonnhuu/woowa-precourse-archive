package vendingmachine.handler;

public enum ErrorHandler {
    INPUT_MONEY("금액은 숫자여야 합니다."),
    INPUT_VENDING_PRODUCTS("상품명과 가격, 수량을 올바르게 입력해야 합니다."),
    VENDING_MONEY_UNIT("금액은 10으로 나누어떨어져야 합니다."),
    VENDING_PRODUCTS_NAME("상품명은 중복되지 않는 이름이어야 합니다."),
    VENDING_PRODUCT_PRICE("상품 가격은 100원부터 시작하며, 10원으로 나누어떨어져야 합니다."),
    PURCHASE_PRODUCT_NAME("구매할 상품이 존재하지 않습니다."),
    PURCHASE_PRODUCT_PRICE("구매할 수 있는 금액이 부족합니다."),
    PURCHASE_PRODUCT_QUANTITY("구매할 수 있는 상품 수량이 없습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorHandler(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(message);
    }
}
