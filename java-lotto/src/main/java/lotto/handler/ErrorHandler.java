package lotto.handler;

import static lotto.util.Constants.LOTTO_MAX_RANGE;
import static lotto.util.Constants.LOTTO_MIN_RANGE;
import static lotto.util.Constants.LOTTO_SIZE;
import static lotto.util.Constants.LOTTO_TICKET_PRICE;

public enum ErrorHandler {

    INVALID_PURCHASE_MONEY_DIGIT("구입 금액은 숫자여야 합니다."),
    INVALID_WINNING_NUMBER_DIGIT("당첨 번호는 숫자여야 합니다."),
    INVALID_BONUS_NUMBER_DIGIT("보너스 번호는 숫자여야 합니다."),

    INVALID_PURCHASE_MONEY_POSITIVE("구입 금액은 양수여야 합니다."),
    INVALID_PURCHASE_MONEY_DIVISION(String.format("구입 금액은 %d원으로 나누어 떨어져야 합니다.", LOTTO_TICKET_PRICE)),

    INVALID_LOTTO_SIZE(String.format("로또 번호는 %d개여야 합니다.", LOTTO_SIZE)),
    INVALID_LOTTO_RANGE(String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", LOTTO_MIN_RANGE, LOTTO_MAX_RANGE)),
    INVALID_LOTTO_DISTINCT("로또 번호는 중복되지 않는 숫자여야 합니다."),

    INVALID_BONUS_NUMBER_RANGE(String.format("보너스 번호는 %d부터 %d 사이의 숫자여야 합니다.", LOTTO_MIN_RANGE, LOTTO_MAX_RANGE)),
    INVALID_BONUS_NUMBER_DISTINCT("보너스 번호는 당첨 번호와 중복되지 않는 숫자여야 합니다.");

    private final String message;

    ErrorHandler(String message) {
        this.message = message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(message);
    }
}
