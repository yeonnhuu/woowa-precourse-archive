package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 보너스_번호가_음수이면_예외가_발생한다() {
        int bonusNumber = -1;
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_1_미만이면_예외가_발생한다() {
        int bonusNumber = 0;
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_45_초과이면_예외가_발생한다() {
        int bonusNumber = 46;
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_중복되면_예외가_발생한다() {
        int bonusNumber = 4;
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
