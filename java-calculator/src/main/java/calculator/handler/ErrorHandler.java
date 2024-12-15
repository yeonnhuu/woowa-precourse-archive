package calculator.handler;

public enum ErrorHandler {
    INVALID_INPUT("유효하지 않은 입력입니다."),
    INVALID_NUMBER("유효하지 않은 숫자입니다.");

    private final String message;

    ErrorHandler(String message) {
        this.message = message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(message);
    }
}
