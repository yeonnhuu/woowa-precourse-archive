package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import vendingmachine.Application;

class VendingProductTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 자판기_상품_입력_그룹_괄호_예외() {
        assertSimpleTest(() -> {
            runException("450","{콜라,1500,20};[사이다,1000,10]");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 자판기_상품_입력_그룹_구분자_예외() {
        assertSimpleTest(() -> {
            runException("450","[콜라,1500,20]:[사이다,1000,10]");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 자판기_상품_입력_빈_그룹_구분자_예외() {
        assertSimpleTest(() -> {
            runException("450","[콜라,1500,20][사이다,1000,10]");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 자판기_상품_정보_부족_예외() {
        assertSimpleTest(() -> {
            runException("450","[콜라,1500]");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 자판기_상품_이름_빈_예외() {
        assertSimpleTest(() -> {
            runException("450","[,1500,20]");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 자판기_상품_이름_공백_예외() {
        assertSimpleTest(() -> {
            runException("450","[ ,1500,20]");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 자판기_상품_이름_중복_예외() {
        assertSimpleTest(() -> {
            runException("450","[콜라,1500,20];[콜라,1000,10]");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 자판기_상품_가격_빈_예외() {
        assertSimpleTest(() -> {
            runException("450","[콜라,1500,20];[사이다,,10]");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 자판기_상품_수량_빈_예외() {
        assertSimpleTest(() -> {
            runException("450","[콜라,1500,20];[사이다,1000,]");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 자판기_상품_가격_음수_예외() {
        assertSimpleTest(() -> {
            runException("450","[콜라,-1500,20];[사이다,1000,10]");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 자판기_상품_수량_음수_예외() {
        assertSimpleTest(() -> {
            runException("450","[콜라,1500,20];[사이다,1000,-10]");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 자판기_상품_수량_부족_예외() {
        assertSimpleTest(() -> {
            runException("450","[콜라,1500,0];[사이다,1000,10]","1200","콜라");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
