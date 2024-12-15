package baseball.controller;

import baseball.domain.Game;
import baseball.validator.GameContinueValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final GameContinueValidator gameContinueValidator = new GameContinueValidator();
    private final Game game = new Game();

    public void run() {
        outputView.printGameStart();
        do {
            game.initializeGame();
            processGame();
            outputView.printGameEnd();
        } while (checkContinueRun());
    }

    private void processGame() {
        while (game.isNotOver()) {
            String input = inputView.readGuess();
            String result = game.tryGuess(input);
            outputView.printGuessResult(result);
        }
    }

    private boolean checkContinueRun() {
        String input = inputView.readGameContinue();
        return gameContinueValidator.validateAndParse(input);
    }
}
