package pairmatching;

import java.io.IOException;
import pairmatching.controller.ServiceManager;

public class Application {
    public static void main(String[] args) {
        try {
            ServiceManager serviceManager = new ServiceManager();
            serviceManager.run();
        } catch (IOException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
