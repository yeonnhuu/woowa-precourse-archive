package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ConverterTest extends NsTest {
    private final Converter converter = new Converter();

    @Test
    void 문자_숫자_변환_기능() {
        List<String> strNumbers = Arrays.asList("1", "2", "3");
        List<Integer> rawNumbers = Arrays.asList(1, 2, 3);
        assertEquals(rawNumbers, converter.stringToInteger(strNumbers));
    }

    @Test
    void 문자_숫자_변환_문자_예외() {
        List<String> strNumbers = Arrays.asList("1", "2", "3", "a", "5");
        assertThrows(IllegalArgumentException.class, () -> converter.stringToInteger(strNumbers));
    }

    @Test
    void 문자_숫자_변환_문자열_예외() {
        List<String> strNumbers = Arrays.asList("1", "2", "3", "abc", "5");
        assertThrows(IllegalArgumentException.class, () -> converter.stringToInteger(strNumbers));
    }

    @Test
    void 문자_숫자_변환_0_예외() {
        List<String> strNumbers = Arrays.asList("1", "2", "3", "0", "5");
        assertThrows(IllegalArgumentException.class, () -> converter.stringToInteger(strNumbers));
    }

    @Test
    void 문자_숫자_변환_음수_예외() {
        List<String> strNumbers = Arrays.asList("1", "2", "3", "-4", "5");
        assertThrows(IllegalArgumentException.class, () -> converter.stringToInteger(strNumbers));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
