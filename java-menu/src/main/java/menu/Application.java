package menu;

import menu.controller.RecommendManager;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new RecommendManager(new InputView(), new OutputView()).run();
    }
}
