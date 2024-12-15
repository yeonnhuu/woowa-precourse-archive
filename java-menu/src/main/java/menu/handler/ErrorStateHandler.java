package menu.handler;

import static menu.util.Constants.CATEGORY_RECOMMEND_MAX_COUNT;

public enum ErrorStateHandler {
    COACH_EXIST("존재하지 않는 코치입니다."),
    CATEGORY_RECOMMEND_COUNT(String.format("한 주에 같은 카테고리는 최대 %d회까지만 고를 수 있습니다.", CATEGORY_RECOMMEND_MAX_COUNT)),
    AVOIDING_RECOMMENDED_MENU("못 먹는 메뉴가 추천되었습니다."),
    DISTINCT_RECOMMENDED_MENU("이미 추천된 메뉴가 추천되었습니다.");

    private final String message;

    ErrorStateHandler(String message) {
        this.message = message;
    }

    public IllegalStateException getException() {
        return new IllegalStateException(message);
    }
}
