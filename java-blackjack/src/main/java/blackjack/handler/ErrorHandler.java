package blackjack.handler;

public enum ErrorHandler {
    INVALID_INPUT("잘못된 값을 입력했습니다."),
    INVALID_NAME("게임에 참여할 사람의 이름을 잘못 입력했습니다."),
    INVALID_BETTING_MONEY("베팅 금액을 잘못 입력했습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorHandler(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(message);
    }
}
