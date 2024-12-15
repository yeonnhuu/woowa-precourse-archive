package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class GameGeneratorTest extends NsTest {
    private GameGenerator gameGenerator = new GameGenerator();

    @Test
    void 랜덤_게임_생성_기능() {
        List<Integer> game = gameGenerator.createRandomGame();
        List<Integer> gameRange = IntStream.rangeClosed(1, 9).boxed().toList();

        assertThat(game.size()).isEqualTo(3);
        assertThat(game).containsAnyElementsOf(gameRange);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
