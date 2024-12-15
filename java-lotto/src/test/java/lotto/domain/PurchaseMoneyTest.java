package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseMoneyTest {
    @Test
    void 구매_금액_음수_예외() {
        assertThatThrownBy(() -> new PurchaseMoney(-2000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매_금액_1000원_단위가_아닌_예외() {
        assertThatThrownBy(() -> new PurchaseMoney(2100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
