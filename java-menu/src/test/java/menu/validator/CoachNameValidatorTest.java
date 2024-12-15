package menu.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CoachNameValidatorTest {

    @Test
    void 코치_이름_길이_2글자_미만_예외() {
        validateException("포");
    }

    @Test
    void 코치_이름_길이_4글자_초과_예외() {
        validateException( "토미토마스");
    }

    private void validateException(String input) {
        assertThatThrownBy(() -> CoachNameValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
