package menu.validator;

import static menu.util.Constants.INPUT_DELIMITER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CoachNamesValidatorTest {

    @Test
    void 코치_이름_개수_2명_미만_예외() {
        validateException("토미");
    }

    @Test
    void 코치_이름_개수_5명_초과_예외() {
        validateException("토미,제임스,포코,구구,워니,포비");
    }

    @Test
    void 코치_이름_중복_예외() {
        validateException("토미,제임스,토미");
    }

    private void validateException(String input) {
        List<String> menus = new ArrayList<>(List.of(input.split(INPUT_DELIMITER)));
        assertThatThrownBy(() -> CoachNamesValidator.validate(menus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
