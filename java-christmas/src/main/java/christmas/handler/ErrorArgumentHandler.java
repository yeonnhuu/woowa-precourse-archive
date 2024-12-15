package christmas.handler;

import static christmas.util.Constants.ERROR_PREFIX;

public enum ErrorArgumentHandler {
    INVALID_INPUT("유효하지 않은 값을 입력했습니다."),
    INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;

    ErrorArgumentHandler(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(message);
    }
}
