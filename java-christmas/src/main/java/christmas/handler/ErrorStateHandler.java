package christmas.handler;

import static christmas.util.Constants.ERROR_PREFIX;

public enum ErrorStateHandler {
    INVALID_MENU("존재하지 않는 메뉴입니다.");

    private final String message;

    ErrorStateHandler(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public IllegalStateException getException() {
        return new IllegalStateException(message);
    }
}
