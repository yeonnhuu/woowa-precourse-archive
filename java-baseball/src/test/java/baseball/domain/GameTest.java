package baseball.domain;

import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    private Game game;

    @BeforeEach
    void setUp() throws Exception {
        game = new Game();
        setPrivateField(game, "answer", Arrays.asList(1, 3, 5));
    }

    @Test
    void 입력_숫자_3스트라이크() {
        List<Integer> guess = Arrays.asList(1, 3, 5);
        game.processGuess(guess);

        assertThat(game.getBall()).isEqualTo(0);
        assertThat(game.getStrike()).isEqualTo(3);
    }

    @Test
    void 입력_숫자_3볼() {
        List<Integer> guess = Arrays.asList(5, 1, 3);
        game.processGuess(guess);

        assertThat(game.getBall()).isEqualTo(3);
        assertThat(game.getStrike()).isEqualTo(0);
    }

    @Test
    void 입력_숫자_2볼_1스트라이크() {
        List<Integer> guess = Arrays.asList(1, 5, 3);
        game.processGuess(guess);

        assertThat(game.getBall()).isEqualTo(2);
        assertThat(game.getStrike()).isEqualTo(1);
    }

    @Test
    void 입력_숫자_낫싱() {
        List<Integer> guess = Arrays.asList(2, 4, 6);
        game.processGuess(guess);

        assertThat(game.getBall()).isEqualTo(0);
        assertThat(game.getStrike()).isEqualTo(0);
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    private int getPrivateField(Object target, String fieldName) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return (int) field.get(target);
    }
}

