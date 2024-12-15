package christmas;

import christmas.controller.EventManager;

public class Application {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        eventManager.run();
    }
}
