package menu.handler;

import static menu.util.Constants.AVOIDING_MENU_MAX_NUMBER;
import static menu.util.Constants.AVOIDING_MENU_MIN_NUMBER;
import static menu.util.Constants.COACH_NAME_MAX_LENGTH;
import static menu.util.Constants.COACH_NAME_MAX_NUMBER;
import static menu.util.Constants.COACH_NAME_MIN_LENGTH;
import static menu.util.Constants.COACH_NAME_MIN_NUMBER;

public enum ErrorArgumentHandler {
    COACH_NAME_NUMBER(String.format("코치는 최소 %d명, 최대 %d명 입력해야 합니다.", COACH_NAME_MIN_NUMBER, COACH_NAME_MAX_NUMBER)),
    COACH_NAME_DISTINCT("코치 이름은 중복되지 않도록 입력해야 합니다."),
    COACH_NAME_LENGTH(String.format("코치 이름은 최소 %d글자, 최대 %d글자 입력해야 합니다.", COACH_NAME_MIN_LENGTH, COACH_NAME_MAX_LENGTH)),
    AVOIDING_MENU_NUMBER(String.format("못 먹는 메뉴는 최소 %d개, 최대 %d개 입력해야 합니다.", AVOIDING_MENU_MIN_NUMBER, AVOIDING_MENU_MAX_NUMBER)),
    AVOIDING_MENU_DISTINCT("못 먹는 메뉴는 중복되지 않도록 입력해야 합니다."),
    AVOIDING_MENU_EXIST("못 먹는 메뉴는 존재하는 메뉴를 입력해야 합니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorArgumentHandler(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(message);
    }
}
