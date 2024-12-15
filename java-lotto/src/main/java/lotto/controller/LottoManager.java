package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Prize;
import lotto.domain.WinningLotto;
import lotto.handler.Rank;
import lotto.handler.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoManager {
    private final Validator validator = new Validator();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private Money money;
    private Lottos lottos;
    private WinningLotto winningLotto;
    private Prize prize = new Prize();

    public void run() {
        getMoney();
        purchaseLottos();
        getWinningLotto();
        calculatePrize();
        outputView.printPrizeStatistic(prize);
    }

    private void getMoney() {
        repeatUntilSuccess(() -> {
            String input = inputView.readMoney();
            int amount = validator.validateMoney(input);
            money = new Money(amount);
            return null;
        });
    }

    private void purchaseLottos() {
        LottoMachine lottoMachine = new LottoMachine();
        lottos = lottoMachine.getLottos(money.getAmount());
        outputView.printPurchaseLottos(lottos.getNumbers());
    }

    private void getWinningLotto() {
        Lotto winLotto = getWinningNumbers();
        getBonusNumber(winLotto);
    }

    private void calculatePrize() {
        for (List<Integer> lotto : lottos.getNumbers()) {
            int matchCount = calculateMatchingWinningNumbers(lotto);
            boolean matchBonus = calculateMatchingBonusNumber(lotto);
            Rank matchRank = Rank.valueOf(matchCount, matchBonus);
            prize.addRank(matchRank);
        }
        prize.calculateTotalPrizeProfit(money.getAmount());
    }

    private int calculateMatchingWinningNumbers(List<Integer> lst) {
        return (int) winningLotto.getNumbers().stream()
                .filter(lst::contains)
                .count();
    }

    private boolean calculateMatchingBonusNumber(List<Integer> lst) {
        return lst.contains(winningLotto.getBonusNumber());
    }

    private Lotto getWinningNumbers() {
        return repeatUntilSuccess(() -> {
            String input = inputView.readWinningNumbers();
            List<Integer> numbers = validator.validateWinningNumbers(input);
            return new Lotto(numbers);
        });
    }

    private void getBonusNumber(Lotto winLotto) {
        repeatUntilSuccess(() -> {
            String input = inputView.readBonusNumber();
            int bonusNumber = validator.validateBonusNumber(input);
            winningLotto = new WinningLotto(winLotto, bonusNumber);
            return null;
        });
    }

    private <T> T repeatUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
