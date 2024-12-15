package christmas.domain;

import java.util.Map;

public enum MenuCourse {
    APPETIZERS(Map.of(
            "양송이수프", 6000,
            "타파스", 5500,
            "시저샐러드", 8000
    )),
    MAIN_DISHES(Map.of(
            "티본스테이크", 55000,
            "바비큐립", 54000,
            "해산물파스타", 35000,
            "크리스마스파스타", 25000
    )),
    DESSERTS(Map.of(
            "초코케이크", 15000,
            "아이스크림", 5000
    )),
    BEVERAGES(Map.of(
            "제로콜라", 3000,
            "레드와인", 60000,
            "샴페인", 25000
    ));

    private final Map<String, Integer> courses;

    MenuCourse(Map<String, Integer> courses) {
        this.courses = courses;
    }

    public Map<String, Integer> getCourses() {
        return courses;
    }
}
