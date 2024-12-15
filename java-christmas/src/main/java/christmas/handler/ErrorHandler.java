package christmas.handler;

public enum ErrorHandler {
    INVALID_VISIT("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_MENU("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorHandler(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(message);
    }
}
