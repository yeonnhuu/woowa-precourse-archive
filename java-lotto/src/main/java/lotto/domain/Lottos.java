package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<List<Integer>> getNumbers() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .toList();
    }
}
