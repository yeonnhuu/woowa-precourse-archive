package calculator;

import calculator.controller.CalculatorManager;

public class Application {
    public static void main(String[] args) {
        CalculatorManager calculatorManager = new CalculatorManager();
        calculatorManager.run();
    }
}
