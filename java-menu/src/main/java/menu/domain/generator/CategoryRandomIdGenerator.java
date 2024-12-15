package menu.domain.generator;

import static menu.util.Constants.CATEGORY_RECOMMEND_MAX_ID;
import static menu.util.Constants.CATEGORY_RECOMMEND_MIN_ID;

import camp.nextstep.edu.missionutils.Randoms;

public class CategoryRandomIdGenerator implements CategoryIdGenerator {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(CATEGORY_RECOMMEND_MIN_ID, CATEGORY_RECOMMEND_MAX_ID);
    }

}
