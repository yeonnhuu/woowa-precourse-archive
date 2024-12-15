package lotto.domain;

import static lotto.util.Constants.LOTTO_MAX_RANGE;
import static lotto.util.Constants.LOTTO_MIN_RANGE;
import static lotto.util.Constants.LOTTO_SIZE;
import static lotto.util.Constants.LOTTO_TICKET_PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoMachine {

    public List<Lotto> generateLottos(PurchaseMoney purchaseMoney) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        int tickets = calculateTickets(purchaseMoney);
        while (tickets-- > 0) {
            purchasedLottos.add(generateLotto());
        }
        return purchasedLottos;
    }

    private int calculateTickets(PurchaseMoney purchaseMoney) {
        return purchaseMoney.getMoney() / LOTTO_TICKET_PRICE;
    }

    private Lotto generateLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_RANGE, LOTTO_MAX_RANGE, LOTTO_SIZE);
        return new Lotto(lottoNumbers);
    }
}
