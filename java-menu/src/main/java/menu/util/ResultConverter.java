package menu.util;

import static menu.util.Constants.RESULT_DELIMITER;
import static menu.util.Constants.RESULT_FINISH;
import static menu.util.Constants.RESULT_START;

import java.util.List;

public class ResultConverter {

    public static String toString(String tag, List<String> data) {
        return RESULT_START
                + tag + RESULT_DELIMITER
                + String.join(RESULT_DELIMITER, data)
                + RESULT_FINISH
                + "\n";
    }
}
