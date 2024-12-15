package subway;

import java.io.IOException;
import java.util.Scanner;
import subway.controller.SubwayManager;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        try {
            SubwayManager subwayManager = new SubwayManager(scanner);
            subwayManager.run();
        } catch (IOException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
