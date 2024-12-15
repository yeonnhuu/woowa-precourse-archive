package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GameStatusTest extends NsTest {

    @Test
    void 게임_3스트라이크_기능() {
        List<Integer> guess = List.of(1, 2, 3);
        List<Integer> answer = List.of(1, 2, 3);

        assertEquals("3스트라이크", GameStatus.processGuess(guess, answer));
    }

    @Test
    void 게임_3볼_기능() {
        List<Integer> guess = List.of(1, 2, 3);
        List<Integer> answer = List.of(3, 1, 2);

        assertEquals("3볼", GameStatus.processGuess(guess, answer));
    }

    @Test
    void 게임_낫싱_기능() {
        List<Integer> guess = List.of(1, 2, 3);
        List<Integer> answer = List.of(4, 5, 6);

        assertEquals("낫싱", GameStatus.processGuess(guess, answer));
    }

    @Test
    void 게임_2볼_기능() {
        List<Integer> guess = List.of(1, 2, 3);
        List<Integer> answer = List.of(3, 5, 1);

        assertEquals("2볼", GameStatus.processGuess(guess, answer));
    }

    @Test
    void 게임_2스트라이크_기능() {
        List<Integer> guess = List.of(1, 2, 3);
        List<Integer> answer = List.of(1, 5, 3);

        assertEquals("2스트라이크", GameStatus.processGuess(guess, answer));
    }

    @Test
    void 게임_2볼_1스트라이크_기능() {
        List<Integer> guess = List.of(1, 2, 3);
        List<Integer> answer = List.of(3, 2, 1);

        assertEquals("2볼 1스트라이크", GameStatus.processGuess(guess, answer));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
