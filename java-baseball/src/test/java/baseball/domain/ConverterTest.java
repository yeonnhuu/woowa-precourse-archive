package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ConverterTest extends NsTest {
    private Converter converter = new Converter();

    @Test
    void 숫자_리스트_변환_기능() {
        String input = "123";
        List<Integer> expected = List.of(1, 2, 3);

        assertEquals(expected, converter.toNumbers(input));
    }

    @Test
    void 숫자_리스트_파싱_예외() {
        String input = "1a3";
        assertThrows(IllegalArgumentException.class, () -> converter.toNumbers(input));
    }

    @Test
    void 숫자_리스트_3개_미만_예외() {
        String input = "12";
        assertThrows(IllegalArgumentException.class, () -> converter.toNumbers(input));
    }

    @Test
    void 숫자_리스트_3개_초과_예외() {
        String input = "1234";
        assertThrows(IllegalArgumentException.class, () -> converter.toNumbers(input));
    }

    @Test
    void 숫자_리스트_범위_예외() {
        String input = "103";

        assertThrows(IllegalArgumentException.class, () -> converter.toNumbers(input));
    }

    @Test
    void 숫자_리스트_중복_예외() {
        String input = "121";

        assertThrows(IllegalArgumentException.class, () -> converter.toNumbers(input));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
