package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @Test
    void 구매_금액이_음수이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Money(-2000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매_금액이_1000단위가_아이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Money(2100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
