package racingcar.handler;

public enum ErrorHandler {
    CAR_NAME_BLANK("자동차 이름은 공백이 아니어야 합니다."),
    CAR_NAME_LENGTH("자동차 이름은 5자 이하여야 합니다."),
    CAR_NAME_DISTINCT("자동차 이름은 중복이 아니어야 합니다."),

    TRY_COUNT_NUMBER("시도할 횟수는 숫자여야 합니다."),
    TRY_COUNT_POSITIVE("시도할 횟수는 양수여야 합니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorHandler(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(message);
    }
}
