package lotto.handler;

public enum ErrorHandler {
    INVALID_INPUT("잘못된 값을 입력했습니다."),
    INVALID_MONEY("구입 금액은 1,000원 단위여야 합니다."),
    LOTTO_NUMBER_SIZE("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBERS("번호들은 중복되지 않는 숫자여야 합니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 중복되지 않는 숫자여야 합니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorHandler(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(message);
    }
}
