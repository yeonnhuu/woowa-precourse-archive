package bridge.handler;

import static bridge.util.Constants.BRIDGE_MAX_SIZE;
import static bridge.util.Constants.BRIDGE_MIN_SIZE;
import static bridge.util.Constants.ERROR_PREFIX;

import bridge.domain.enums.GameOptions;
import bridge.domain.enums.MoveOptions;

public enum ErrorArgumentHandler {

    INVALID_BRIDGE_SIZE_DIGIT("다리의 길이는 숫자여야 합니다."),
    INVALID_BRIDGE_SIZE_RANGE(String.format("다리의 길이는 %d 이상 %d 이하여야 합니다.", BRIDGE_MIN_SIZE, BRIDGE_MAX_SIZE)),
    INVALID_MOVE_OPTION_COMMAND(String.format("이동할 칸은 %s 또는 %s를 입력해야 합니다.", MoveOptions.U.name(), MoveOptions.D.name())),
    INVALID_GAME_OPTION_COMMAND(String.format("게임을 다시 시도할지 여부는 %s 또는 %s를 입력해야 합니다.", GameOptions.R.name(), GameOptions.Q.name()));

    private final String message;

    ErrorArgumentHandler(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(message);
    }
}
