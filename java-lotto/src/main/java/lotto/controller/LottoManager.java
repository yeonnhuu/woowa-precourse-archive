package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.domain.Prize;
import lotto.domain.PurchaseLottos;
import lotto.domain.PurchaseMoney;
import lotto.domain.PrizeLotto;
import lotto.util.RepeatExecutor;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RepeatExecutor repeatExecutor = new RepeatExecutor(outputView);
    private final InputValidator inputValidator = new InputValidator();

    private PurchaseMoney purchaseMoney;
    private PurchaseLottos purchaseLottos;
    private PrizeLotto prizeLotto;

    public void run() {
        processPurchaseLottos();
        processPrizeLotto();
        processPurchasePrize();
    }

    private void processPurchaseLottos() {
        drawPurchaseLottos();
        outputView.printPurchaseLottos(purchaseLottos.toString());
    }

    private void processPrizeLotto() {
        Lotto winningLotto = drawWinningLotto();
        drawPrizeLotto(winningLotto);
    }

    private void processPurchasePrize() {
        Prize prize = new Prize(purchaseLottos, prizeLotto);
        outputView.printPrizeStatistic(prize.statisticsToString());
        outputView.printPrizeProfit(prize.profitToString(purchaseMoney));
    }

    private void drawPurchaseLottos() {
        repeatExecutor.repeatUntilSuccess(() -> {
            String input = inputView.readPurchaseMoney();
            int money = inputValidator.validateAndParsePurchaseMoney(input);
            purchaseMoney = new PurchaseMoney(money);
            purchaseLottos = new PurchaseLottos(purchaseMoney);
            return null;
        });
    }

    private void drawPrizeLotto(Lotto winningLotto) {
        repeatExecutor.repeatUntilSuccess(() -> {
            String input = inputView.readBonusNumber();
            int bonusNumber = inputValidator.validateAndParseBonusNumber(input);
            prizeLotto = new PrizeLotto(winningLotto, bonusNumber);
            return null;
        });
    }

    private Lotto drawWinningLotto() {
        return repeatExecutor.repeatUntilSuccess(() -> {
            String input = inputView.readWinningNumbers();
            List<Integer> winningNumbers = inputValidator.validateAndParseWinningNumbers(input);
            return new Lotto(winningNumbers);
        });
    }



}
