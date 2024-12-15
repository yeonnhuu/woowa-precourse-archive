package lotto.domain;

import static lotto.handler.ErrorHandler.DUPLICATE_BONUS_NUMBER;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        super(winningLotto.getNumbers());
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicateBonusNumber(bonusNumber);
    }

    private void validateDuplicateBonusNumber(int bonusNumber) {
        if (getWinningNumbers().contains(bonusNumber)) {
            throw DUPLICATE_BONUS_NUMBER.getException();
        }
    }
}
