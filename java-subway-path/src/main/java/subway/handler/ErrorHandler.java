package subway.handler;

public enum ErrorHandler {
    INVALID_INPUT("잘못된 값을 입력했습니다."),
    INVALID_STATION("존재하지 않는 지하철 역입니다."),
    IDENTICAL_STATIONS("출발역과 도착역이 동일합니다."),
    DISCONNECTED_STATIONS("출발역과 도착역이 연결되어 있지 않습니다.");

    private final String message;

    ErrorHandler(String message) {
        this.message = message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(message);
    }
}
