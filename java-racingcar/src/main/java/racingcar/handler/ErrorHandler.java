package racingcar.handler;

public enum ErrorHandler {
    INVALID_INPUT("[ERROR] 잘못된 값을 입력했습니다.");

    private final String message;

    ErrorHandler(String message) {
        this.message = message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(message);
    }
}
