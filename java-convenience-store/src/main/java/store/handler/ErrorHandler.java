package store.handler;

public enum ErrorHandler {
    INVALID_PURCHASE("올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요."),
    PRODUCT_NULL("존재하지 않는 상품입니다. 다시 입력해 주세요."),
    QUANTITY_EXCEED("재고 수량을 초과하여 구매할 수 없습니다. 다시 입력해 주세요."),
    INVALID_INPUT("잘못된 입력입니다. 다시 입력해 주세요.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorHandler(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(message);
    }
}
