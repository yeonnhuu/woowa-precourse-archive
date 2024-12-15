package baseball.domain;

import static baseball.util.GameConstants.GAME_MAX_NUMBER;
import static baseball.util.GameConstants.GAME_MIN_NUMBER;
import static baseball.util.GameConstants.GAME_NUMBERS_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameGenerator {
    
    public List<Integer> createRandomGame() {
        List<Integer> game = new ArrayList<>();
        while (game.size() < GAME_NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(GAME_MIN_NUMBER, GAME_MAX_NUMBER);
            if (!game.contains(randomNumber)) {
                game.add(randomNumber);
            }
        }
        return game;
    }
}
