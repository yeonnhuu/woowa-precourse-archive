package bridge.handler;

import static bridge.util.Constants.ERROR_PREFIX;

public enum ErrorStateHandler {

    INVALID_BRIDGE_NUMBER("유효하지 않은 다리 숫자입니다.");

    private final String message;

    ErrorStateHandler(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public IllegalStateException getException() {
        return new IllegalStateException(message);
    }
}
