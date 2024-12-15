package menu.validator;

import static menu.util.Constants.INPUT_DELIMITER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AvoidingMenusValidatorTest {

    @Test
    void 못_먹는_음식_2개_초과_예외() {
        validateException("우동,스시,뇨끼");
    }

    @Test
    void 못_먹는_음식_중복_예외() {
        validateException("김밥,김밥");
    }

    @Test
    void 못_먹는_음식_존재하지_않는_예외() {
        validateException("김밥,와플");
    }

    private void validateException(String input) {
        List<String> menus = new ArrayList<>(List.of(input.split(INPUT_DELIMITER)));
        assertThatThrownBy(() -> AvoidingMenusValidator.validate(menus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
