package bridge.domain.enums;

import static bridge.handler.ErrorStateHandler.INVALID_BRIDGE_NUMBER;

public enum MoveOptions {
    U(1),
    D(0);

    private final int value;

    MoveOptions(int value) {
        this.value = value;
    }

    public static String findCommandBy(int value) {
        for (MoveOptions moveOption : MoveOptions.values()) {
            if (moveOption.value == value) {
                return moveOption.name();
            }
        }
        throw INVALID_BRIDGE_NUMBER.getException();
    }
}
