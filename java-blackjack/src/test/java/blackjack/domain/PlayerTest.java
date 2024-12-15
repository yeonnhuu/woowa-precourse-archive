package blackjack.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import blackjack.Application;
import blackjack.domain.user.Dealer;
import blackjack.domain.user.Player;
import blackjack.domain.user.Status;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest extends NsTest {
    private Player player;
    private Dealer dealer;

    @BeforeEach
    void setUp() {
        player = new Player("pobi", 10000);
        dealer = new Dealer();
    }

    void setUserPrivateField(Status pStatus, Status dStatus, int pScore, int dScore) throws Exception {
        setPrivateField(player, "status", pStatus);
        setPrivateField(dealer, "status", dStatus);
        setPrivateField(player, "totalScore", pScore);
        setPrivateField(dealer, "totalScore", dScore);
    }

    // 플레이어 PLAY 딜러 PLAY
    @Test
    void 플레이어_PLAY_딜러_PLAY_게임_플레이어_우승_수익_비율() throws Exception {
        setUserPrivateField(Status.PLAY, Status.PLAY, 15, 10);
        assertThat(player.calculateStatusValue(dealer)).isEqualTo(1.0);
    }

    @Test
    void 플레이어_PLAY_딜러_PLAY_게임_플레어어_무승부_수익_비율() throws Exception {
        setUserPrivateField(Status.PLAY, Status.PLAY, 10, 10);
        assertThat(player.calculateStatusValue(dealer)).isEqualTo(0.0);
    }

    @Test
    void 플레이어_PLAY_딜러_PLAY_게임_플레어어_패배_수익_비율() throws Exception {
        setUserPrivateField(Status.PLAY, Status.PLAY, 10, 15);
        assertThat(player.calculateStatusValue(dealer)).isEqualTo(-1.0);
    }

    // 플레이어 BLACKJACK
    @Test
    void 플레이어_BLACKJACK_딜러_BLACKJACK_게임_플레이어_우승_수익_비율() throws Exception {
        setUserPrivateField(Status.BLACKJACK, Status.BLACKJACK, 21, 21);
        assertThat(player.calculateStatusValue(dealer)).isEqualTo(0.0);
    }

    @Test
    void 플레이어_BLACKJACK_딜러_WIN_게임_플레이어_우승_수익_비율() throws Exception {
        setUserPrivateField(Status.BLACKJACK, Status.WIN, 21, 21);
        assertThat(player.calculateStatusValue(dealer)).isEqualTo(1.5);
    }

    @Test
    void 플레이어_BLACKJACK_딜러_PLAY_게임_플레이어_우승_수익_비율() throws Exception {
        setUserPrivateField(Status.BLACKJACK, Status.PLAY, 21, 20);
        assertThat(player.calculateStatusValue(dealer)).isEqualTo(1.5);
    }

    @Test
    void 플레이어_BLACKJACK_딜러_BUST_게임_플레이어_우승_수익_비율() throws Exception {
        setUserPrivateField(Status.BLACKJACK, Status.BUST, 21, 22);
        assertThat(player.calculateStatusValue(dealer)).isEqualTo(1.0);
    }

    // 플레이어 WIN
    @Test
    void 플레이어_WIN_딜러_BLACKJACK_게임_플레이어_우승_수익_비율() throws Exception {
        setUserPrivateField(Status.WIN, Status.BLACKJACK, 21, 21);
        assertThat(player.calculateStatusValue(dealer)).isEqualTo(0.0);
    }

    @Test
    void 플레이어_WIN_딜러_WIN_게임_플레이어_우승_수익_비율() throws Exception {
        setUserPrivateField(Status.WIN, Status.WIN, 21, 21);
        assertThat(player.calculateStatusValue(dealer)).isEqualTo(0.0);
    }

    @Test
    void 플레이어_WIN_딜러_PLAY_게임_플레이어_우승_수익_비율() throws Exception {
        setUserPrivateField(Status.WIN, Status.PLAY, 21, 20);
        assertThat(player.calculateStatusValue(dealer)).isEqualTo(1.0);
    }

    @Test
    void 플레이어_WIN_딜러_BUST_게임_플레이어_우승_수익_비율() throws Exception {
        setUserPrivateField(Status.WIN, Status.BUST, 21, 22);
        assertThat(player.calculateStatusValue(dealer)).isEqualTo(1.0);
    }

    // 플레이어 PLAY 딜러 !PLAY
    @Test
    void 플레이어_PLAY_딜러_BLACKJACK_게임_플레이어_우승_수익_비율() throws Exception {
        setUserPrivateField(Status.PLAY, Status.BLACKJACK, 20, 21);
        assertThat(player.calculateStatusValue(dealer)).isEqualTo(-1.0);
    }

    @Test
    void 플레이어_PLAY_딜러_WIN_게임_플레이어_우승_수익_비율() throws Exception {
        setUserPrivateField(Status.PLAY, Status.WIN, 20, 21);
        assertThat(player.calculateStatusValue(dealer)).isEqualTo(-1.0);
    }

    @Test
    void 플레이어_PLAY_딜러_BUST_게임_플레이어_우승_수익_비율() throws Exception {
        setUserPrivateField(Status.PLAY, Status.BUST, 20, 22);
        assertThat(player.calculateStatusValue(dealer)).isEqualTo(1.0);
    }

    // 플레이어 BUST
    @Test
    void 플레이어_BUST_딜러_BLACKJACK_게임_플레이어_우승_수익_비율() throws Exception {
        setUserPrivateField(Status.BUST, Status.BLACKJACK, 22, 21);
        assertThat(player.calculateStatusValue(dealer)).isEqualTo(-1.0);
    }

    @Test
    void 플레이어_BUST_딜러_WIN_게임_플레이어_우승_수익_비율() throws Exception {
        setUserPrivateField(Status.BUST, Status.WIN, 22, 21);
        assertThat(player.calculateStatusValue(dealer)).isEqualTo(-1.0);
    }

    @Test
    void 플레이어_BUST_딜러_PLAY_게임_플레이어_우승_수익_비율() throws Exception {
        setUserPrivateField(Status.BUST, Status.PLAY, 22, 15);
        assertThat(player.calculateStatusValue(dealer)).isEqualTo(-1.0);
    }

    @Test
    void 플레이어_BUST_딜러_BUST_게임_플레이어_우승_수익_비율() throws Exception {
        setUserPrivateField(Status.BUST, Status.BUST, 22, 22);
        assertThat(player.calculateStatusValue(dealer)).isEqualTo(1.0);
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        Class<?> clazz = target.getClass();
        Field field;

        while (clazz != null) {
            try {
                field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(target, value);
                return;
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field '" + fieldName + "' not found in class hierarchy of " + target.getClass());
    }

    private Object getPrivateField(Object target, String fieldName) throws Exception {
        Class<?> clazz = target.getClass();
        Field field;

        while (clazz != null) {
            try {
                field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                return field.get(target);
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field '" + fieldName + "' not found in class hierarchy of " + target.getClass());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
