package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class StringParserTest extends NsTest {
    private final StringParser stringParser = new StringParser();
    private final List<String> numbers = List.of("1", "2", "3", "4", "5");

    @Test
    void 기본_구분자_파싱_기능() {
        String input = "1,2:3:4,5";
        assertEquals(numbers, stringParser.parse(input));
    }

    @Test
    void 커스텀_구분자_문자_파싱_기능() {
        String input = "//;\\n1,2:3;4,5";
        assertEquals(numbers, stringParser.parse(input));
    }

    @Test
    void 커스텀_구분자_문자열_파싱_기능() {
        String input = "//&&\\n1,2:3:4&&5";
        assertEquals(numbers, stringParser.parse(input));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
