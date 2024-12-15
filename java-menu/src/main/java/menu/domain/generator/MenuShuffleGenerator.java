package menu.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class MenuShuffleGenerator {

    public List<String> generate(List<String> menus) {
        return Randoms.shuffle(menus);
    }
}
