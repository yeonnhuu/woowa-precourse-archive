package christmas.domain.enums;

import static christmas.handler.ErrorStateHandler.INVALID_MENU;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public enum Course {
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

    private final Map<String, Integer> menus;

    Course(Map<String, Integer> menus) {
        this.menus = menus;
    }

    public static List<String> getAllMenuNames() {
        List<String> menuNames = new ArrayList<>();
        for (Course course : Course.values()) {
            menuNames.addAll(course.menus.keySet());
        }
        return menuNames;
    }

    public static int getMenuPrice(String menuName) {
        for (Course course : Course.values()) {
            if (course.menus.containsKey(menuName)) {
                return course.menus.get(menuName);
            }
        }
        throw INVALID_MENU.getException();
    }

    public Set<String> getMenuNames() {
        return this.menus.keySet();
    }
}
