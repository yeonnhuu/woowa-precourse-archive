package racingcar;

import racingcar.controller.RaceManager;

public class Application {
    public static void main(String[] args) {
        RaceManager raceManager = new RaceManager();
        raceManager.run();
    }
}
