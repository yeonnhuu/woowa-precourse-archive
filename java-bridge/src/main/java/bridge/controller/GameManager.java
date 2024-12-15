package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.util.RepeatExecutor;
import bridge.validator.BridgeSizeValidator;
import bridge.validator.GameOptionsValidator;
import bridge.validator.MoveOptionsValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameManager {

    private final InputView inputView;
    private final OutputView outputView;
    private final RepeatExecutor repeatExecutor;

    private Bridge bridge;
    private BridgeGame bridgeGame;
    private int tryCount;

    public GameManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.repeatExecutor = new RepeatExecutor(outputView);
    }

    public void run() {
        start();
        do {
            tryCount++;
            process();
            if (bridgeGame.isSuccessful()) {
                break;
            }
        } while (checkContinueGame());
        finish();
    }

    private void start() {
        outputView.printGameStartMessage();
        int bridgeSize = repeatExecutor.repeatUntilSuccess(this::prepareBridgeSize);
        bridge = repeatExecutor.repeatUntilSuccess(() -> new Bridge(bridgeSize));
        bridgeGame = new BridgeGame(bridge);
        tryCount = 0;
    }

    private void process() {
        boolean canMove;
        do {
            String moveCommand = repeatExecutor.repeatUntilSuccess(this::prepareMoveCommand);
            canMove = bridgeGame.move(moveCommand);
            outputView.printMap(bridge.getSteps(), bridgeGame.getSteps());
        } while (canMove && !bridgeGame.isSuccessful());
    }

    private void finish() {
        outputView.printResultHeader();
        outputView.printMap(bridge.getSteps(), bridgeGame.getSteps());
        outputView.printResultSuccess(bridgeGame.isSuccessful());
        outputView.printResultTryCount(tryCount);
    }

    private boolean checkContinueGame() {
        boolean continueGame = repeatExecutor.repeatUntilSuccess(this::prepareGameCommand);
        if (continueGame) {
            bridgeGame.retry();
        }
        return continueGame;
    }

    private int prepareBridgeSize() {
        String input = inputView.readBridgeSize();
        return BridgeSizeValidator.validateAndParse(input);
    }

    private String prepareMoveCommand() {
        String input = inputView.readMoving();
        return MoveOptionsValidator.validateAndParse(input);
    }

    private boolean prepareGameCommand() {
        String input = inputView.readGameCommand();
        return GameOptionsValidator.validateAndParse(input);
    }
}
