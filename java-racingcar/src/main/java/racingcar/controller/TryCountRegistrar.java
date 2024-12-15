package racingcar.controller;

import racingcar.handler.ValidationHandler;
import racingcar.view.InputView;

public class TryCountRegistrar {
    private final InputView inputView;
    private final ValidationHandler validationHandler = new ValidationHandler();

    public TryCountRegistrar(InputView inputView) {
        this.inputView = inputView;
    }

    public int registerTryCount() {
        String input = inputView.readTryCount();
        validationHandler.validateInput(input);
        validationHandler.validateTryCount(input);
        return Integer.parseInt(input);
    }
}
