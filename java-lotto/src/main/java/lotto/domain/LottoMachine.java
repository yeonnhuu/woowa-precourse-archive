package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_UNIT = 1000;

    public Lottos getLottos(int money) {
        Lottos lottos = new Lottos();
        int lottoTickets = money / LOTTO_UNIT;
        while (lottoTickets-- > 0) {
            lottos.add(generateLottoNumbers());
        }
        return lottos;
    }

    public Lotto generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
