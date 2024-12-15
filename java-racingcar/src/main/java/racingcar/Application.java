package racingcar;

import racingcar.controller.RacingManager;

public class Application {
    public static void main(String[] args) {
        RacingManager racingManager = new RacingManager();
        racingManager.run();
    }
}
