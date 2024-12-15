package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrizeLottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 보너스_번호_음수_예외() {
        int bonusNumber = -1;
        assertThatThrownBy(() -> new PrizeLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_1_미만_예외() {
        int bonusNumber = 0;
        assertThatThrownBy(() -> new PrizeLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_45_초과_예외() {
        int bonusNumber = 46;
        assertThatThrownBy(() -> new PrizeLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_중복_예외() {
        int bonusNumber = 4;
        assertThatThrownBy(() -> new PrizeLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호과_보너스_번호_일치_계산_기능() {
        Lotto purchaseLotto = new Lotto(List.of(1, 2, 3, 14, 15, 16));
        PrizeLotto prizeLotto = new PrizeLotto(lotto, 14);
        assertEquals(3, prizeLotto.calculateMatchCount(purchaseLotto));
    }

    @Test
    void 당첨_번호만_일치_계산_기능() {
        Lotto purchaseLotto = new Lotto(List.of(1, 2, 3, 14, 15, 16));
        PrizeLotto prizeLotto = new PrizeLotto(lotto, 7);
        assertEquals(3, prizeLotto.calculateMatchCount(purchaseLotto));
    }

    @Test
    void 보너스_번호가_필요한_계산_기능() {
        Lotto purchaseLotto = new Lotto(List.of(1, 2, 3, 4, 5, 16));
        PrizeLotto prizeLotto = new PrizeLotto(lotto, 16);
        assertTrue(prizeLotto.calculateRequireBonus(purchaseLotto));
    }

    @Test
    void 보너스_번호가_필요_없는_계산_기능() {
        Lotto purchaseLotto = new Lotto(List.of(1, 2, 3, 4, 15, 16));
        PrizeLotto prizeLotto = new PrizeLotto(lotto, 16);
        assertFalse(prizeLotto.calculateRequireBonus(purchaseLotto));
    }
}
