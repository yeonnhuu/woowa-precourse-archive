package vendingmachine;

import vendingmachine.controller.VendingManager;

public class Application {
    public static void main(String[] args) {
        VendingManager vendingManager = new VendingManager();
        vendingManager.run();
    }
}
