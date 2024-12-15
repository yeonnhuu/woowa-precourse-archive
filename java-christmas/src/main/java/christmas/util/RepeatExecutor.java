package christmas.util;

import christmas.view.OutputView;
import java.util.function.Supplier;

public class RepeatExecutor {
    private final OutputView outputView;

    public RepeatExecutor(OutputView outputView) {
        this.outputView = outputView;
    }

    public <T> T repeatUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
