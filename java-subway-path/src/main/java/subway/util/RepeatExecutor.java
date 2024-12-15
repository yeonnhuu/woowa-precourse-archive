package subway.util;

import java.util.function.Supplier;
import subway.view.OutputView;

public class RepeatExecutor {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private final OutputView outputView;

    public RepeatExecutor(OutputView outputView) {
        this.outputView = outputView;
    }

    public <T> T repeatUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage("\n" + ERROR_PREFIX + e.getMessage());
            }
        }
    }
}
