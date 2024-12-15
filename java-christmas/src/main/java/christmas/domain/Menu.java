package christmas.domain;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menu {
    private static final Map<String, Integer> MENUS;

    static {
        MENUS = Stream.of(MenuCourse.values())
                .flatMap(menuCourse -> menuCourse.getCourses().entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Set<String> getMenuNames() {
        return MENUS.keySet();
    }

    public static Set<String> getMenuNamesByCourse(MenuCourse menuCourse) {
        return menuCourse.getCourses()
                .keySet();
    }

    public static int getPrice(String name) {
        return MENUS.get(name);
    }
}
