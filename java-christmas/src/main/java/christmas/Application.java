package christmas;

import christmas.controller.EventManager;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new EventManager(new InputView(), new OutputView()).run();
    }
}
