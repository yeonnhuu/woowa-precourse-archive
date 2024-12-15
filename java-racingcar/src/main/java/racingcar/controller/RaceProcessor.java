package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Cars;
import racingcar.view.OutputView;

public class RaceProcessor {
    private static final int RANGE_MIN = 0;
    private static final int RANGE_MAX = 9;

    private final OutputView outputView;
    private final Cars cars;
    private int tryCount;

    public RaceProcessor(OutputView outputView, Cars cars) {
        this.outputView = outputView;
        this.cars = cars;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public void processRaceGame() {
        outputView.printProcessHeader();
        while (tryCount-- > 0) {
            processGame();
            outputView.printProcessResult(cars.getCarNames(), cars.getCarPositions());
        }
    }

    private void processGame() {
        cars.getCars().forEach(car -> car.move(Randoms.pickNumberInRange(RANGE_MIN, RANGE_MAX)));
    }
}
