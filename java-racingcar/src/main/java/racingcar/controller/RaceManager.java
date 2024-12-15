package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class RaceManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Cars cars = new Cars();

    private final CarRegistrar carRegistrar = new CarRegistrar(inputView, cars);
    private final TryCountRegistrar tryCountRegistrar = new TryCountRegistrar(inputView);
    private final RaceProcessor raceProcessor = new RaceProcessor(outputView, cars);
    private final WinnerProcessor winnerProcessor = new WinnerProcessor(cars);

    public void run() {
        startRace();
        processRace();
        finishRace();
    }

    private void startRace() {
        carRegistrar.registerCars();
        int tryCount = tryCountRegistrar.registerTryCount();
        raceProcessor.setTryCount(tryCount);
    }


    private void processRace() {
        raceProcessor.processRaceGame();
    }

    private void finishRace() {
        List<String> names = winnerProcessor.getWinnerNames();
        outputView.printWinner(names);
    }
}
