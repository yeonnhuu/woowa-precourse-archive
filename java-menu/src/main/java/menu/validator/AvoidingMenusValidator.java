package menu.validator;


import static menu.handler.ErrorArgumentHandler.AVOIDING_MENU_DISTINCT;
import static menu.handler.ErrorArgumentHandler.AVOIDING_MENU_EXIST;
import static menu.handler.ErrorArgumentHandler.AVOIDING_MENU_NUMBER;
import static menu.util.Constants.AVOIDING_MENU_MAX_NUMBER;
import static menu.util.Constants.AVOIDING_MENU_MIN_NUMBER;

import java.util.List;
import menu.domain.enums.Category;

public class AvoidingMenusValidator {

    public static void validate(List<String> menus) {
        validateNumber(menus);
        validateDistinct(menus);
        validateExists(menus);
    }

    private static void validateNumber(List<String> menus) {
        if (menus.size() < AVOIDING_MENU_MIN_NUMBER || menus.size() > AVOIDING_MENU_MAX_NUMBER) {
            throw AVOIDING_MENU_NUMBER.getException();
        }
    }

    private static void validateDistinct(List<String> menus) {
        if (menus.stream().distinct().count() != menus.size()) {
            throw AVOIDING_MENU_DISTINCT.getException();
        }
    }

    private static void validateExists(List<String> menus) {
        List<String> lunchMenus = Category.getAllMenuNames();
        for (String menu : menus) {
            validateExist(lunchMenus, menu);
        }
    }

    private static void validateExist(List<String> lunchMenus, String menu) {
        if (!lunchMenus.contains(menu)) {
            throw AVOIDING_MENU_EXIST.getException();
        }
    }
}
