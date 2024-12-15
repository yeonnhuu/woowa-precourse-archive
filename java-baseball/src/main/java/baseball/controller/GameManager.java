package baseball.controller;

import static baseball.handler.ErrorHandler.INVALID_INPUT;

import baseball.domain.Game;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GameManager {
    private static final Pattern GUESS_PATTERN = Pattern.compile("[1-9]{3}");
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Game game;

    public void run() {
        outputView.printStart();
        boolean continueRun;
        do {
            game = new Game();
            playGame();
            continueRun = checkContinueRun();
        } while (continueRun);
    }

    private void playGame() {
        boolean continueGuess;
        do {
            String input = getGuess();
            List<Integer> numbers = getNumbers(input);
            game.processGuess(numbers);
            outputView.printGuessResult(game.getBall(), game.getStrike());
            continueGuess = checkContinueGuess();
        } while (continueGuess);
        outputView.printFinish();
    }

    private String getGuess() {
        String input = inputView.readGuess();
        validateGuess(input);
        return input;
    }

    private List<Integer> getNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        char[] guesses = input.trim().toCharArray();
        for (char guess : guesses) {
            numbers.add(Integer.parseInt(String.valueOf(guess)));
        }
        validateNumbers(numbers);
        return numbers;
    }

    private boolean checkContinueRun() {
        String input = inputView.readContinue();
        validateYesNoInput(input);
        return input.equals("1");
    }

    private boolean checkContinueGuess() {
        return game.isWrongGuess();
    }

    private void validateGuess(String input) {
        if (!GUESS_PATTERN.matcher(input).matches()) {
            throw INVALID_INPUT.getException();
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw INVALID_INPUT.getException();
        }
    }

    private void validateYesNoInput(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw INVALID_INPUT.getException();
        }
    }
}
