package calculator.controller;

import calculator.model.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final StringCalculator stringCalculator = new StringCalculator();

    public void run() {
        String input = inputView.readExpression();
        int result = stringCalculator.calculateSum(input);
        outputView.printResult(result);
    }
}
