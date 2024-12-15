package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import vendingmachine.Application;

class VendingProductsTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 자판기_상품_검색_예외() {
        assertSimpleTest(() -> {
            runException("450","[콜라,1500,20];[사이다,1000,10]","3000","주스");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
