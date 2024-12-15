package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest extends NsTest {
    private final StringCalculator stringCalculator = new StringCalculator();

    @Test
    void 숫자_총합_계산_기능() {
        assertEquals(6, stringCalculator.sum(Arrays.asList("1", "2", "3")));
    }

    @Test
    void 숫자_총합_계산_음수_예외() {
        assertThrows(IllegalArgumentException.class, () -> stringCalculator.sum(Arrays.asList("-1", "-2", "-3")));
    }

    @Test
    void 숫자_총합_계산_0_예외() {
        assertThrows(IllegalArgumentException.class, () -> stringCalculator.sum(Arrays.asList("-1", "0", "1")));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
