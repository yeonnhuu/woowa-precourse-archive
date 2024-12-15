package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.validator.CarNamesValidator;
import racingcar.validator.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CarNamesValidator carNamesValidator = new CarNamesValidator();
    private final TryCountValidator tryCountValidator = new TryCountValidator();

    private final Cars cars = new Cars();

    public void run() {
        registerRacing();
        processRacing();
        finishRacing();
    }

    private void registerRacing() {
        List<String> carNames = carNamesValidator.validateAndParse(inputView.readCarNames());
        for (String name : carNames) {
            cars.registerCar(name);
        }
    }

    private void processRacing() {
        int tryCount = tryCountValidator.validateAndParse(inputView.readTryCount());
        outputView.printRacingResult();
        while (tryCount-- > 0) {
            cars.race();
            outputView.printRacingProcess(cars.toString());
        }
    }

    private void finishRacing() {
        outputView.printRacingWinners(cars.findWinners());
    }

}
