package lotto.domain;

import static lotto.handler.ErrorHandler.INVALID_BONUS_NUMBER_DISTINCT;

import lotto.Lotto;

public class PrizeLotto extends Lotto {
    private final int bonusNumber;

    public PrizeLotto(Lotto winningLotto, int bonusNumber) {
        super(winningLotto.getNumbers());
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int calculateMatchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(getNumbers()::contains)
                .count();
    }

    public boolean calculateRequireBonus(Lotto lotto) {
        int matchCount = calculateMatchCount(lotto);
        return matchCount == 5 && lotto.getNumbers().contains(bonusNumber);
    }

    private void validate(int bonusNumber) {
        validateRange(bonusNumber);
        validateDistinct(bonusNumber);
    }

    private void validateDistinct(int bonusNumber) {
        if (getNumbers().contains(bonusNumber)) {
            throw INVALID_BONUS_NUMBER_DISTINCT.getException();
        }
    }
}
