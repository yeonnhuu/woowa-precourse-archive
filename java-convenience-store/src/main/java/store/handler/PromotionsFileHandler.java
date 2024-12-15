package store.handler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import store.domain.Event;
import store.domain.Promotions;

public class PromotionsFileHandler {
    private static final Path PROMOTIONS_PATH = Path.of("src/main/resources/promotions.md");
    private Promotions promotions;

    public Promotions generatePromotions() throws IOException {
        promotions = new Promotions();
        List<String> lines = Files.readAllLines(PROMOTIONS_PATH);
        for (String line : lines.subList(1, lines.size())) {
            addPromotionFromLine(line);
        }
        return promotions;
    }

    private void addPromotionFromLine(String line) {
        String[] fields = line.split(",");
        String name = fields[0];
        int buy = parseInteger(fields[1]);
        int get = parseInteger(fields[2]);
        LocalDate startDate = parseDate(fields[3]);
        LocalDate endDate = parseDate(fields[4]);

        Event event = new Event(buy, get, startDate, endDate);
        promotions.addEvent(name, event);
    }

    private int parseInteger(String value) {
        return Integer.parseInt(value);
    }

    private LocalDate parseDate(String value) {
        return LocalDate.parse(value);
    }
}
