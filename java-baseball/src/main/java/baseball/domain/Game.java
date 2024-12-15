package baseball.domain;

import java.util.List;

public class Game {
    private final GameGenerator gameGenerator ;
    private final Converter converter ;
    private List<Integer> game;

    public Game() {
        gameGenerator = new GameGenerator();
        converter = new Converter();
    }

    public void initializeGame() {
        game = gameGenerator.createRandomGame();
        GameStatus.initializeStatus();
    }

    public String tryGuess(String input) {
        List<Integer> guess = converter.toNumbers(input);
        return GameStatus.processGuess(guess, game);
    }

    public boolean isNotOver() {
        return !GameStatus.isAllStrike();
    }
}
