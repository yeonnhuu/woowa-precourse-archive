package pairmatching.handler;

public enum ErrorHandler {
    INVALID_INPUT("잘못된 값을 입력했습니다."),
    UNAVAILABLE_VIEW("매칭 이력이 없습니다."),
    UNAVAILABLE_MATCH("매칭 할 수 없습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorHandler(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(message);
    }
}
