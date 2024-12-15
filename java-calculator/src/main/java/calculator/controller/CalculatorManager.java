package calculator.controller;

import calculator.domain.StringCalculator;
import calculator.domain.StringParser;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final StringParser stringParser = new StringParser();
    private final StringCalculator stringCalculator = new StringCalculator();

    public void run() {
        String input = inputView.readStringToCalculate();
        List<String> strNumbers = stringParser.parse(input);
        int result = stringCalculator.sum(strNumbers);
        outputView.printResult(result);
    }
}
