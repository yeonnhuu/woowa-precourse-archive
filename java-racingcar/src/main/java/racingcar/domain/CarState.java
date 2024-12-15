package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CarState {
    private static final String PROGRESS_BAR = "-";
    private static final int MIN_MOVE = 0;
    private static final int MAX_MOVE = 9;
    private static final int MOVE_THRESHOLD = 4;
    private int position;

    public CarState() {
        this.position = 0;
    }

    public void move() {
        if (isMovable()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public boolean hasPosition(int otherPosition) {
        return position == otherPosition;
    }

    public String toString() {
        return PROGRESS_BAR.repeat(position);
    }

    private boolean isMovable() {
        return generateRandomMove() >= MOVE_THRESHOLD;
    }

    private int generateRandomMove() {
        return Randoms.pickNumberInRange(MIN_MOVE, MAX_MOVE);
    }
}
