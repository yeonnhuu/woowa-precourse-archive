package store.util;

import java.util.function.Supplier;
import store.view.OutputView;

public class RepeatExecutor {

    public static <T> T repeatUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
