package bridge;

import bridge.controller.GameManager;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new GameManager(new InputView(), new OutputView()).run();
    }
}
