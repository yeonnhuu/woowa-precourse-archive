package menu.domain;

import static menu.handler.ErrorStateHandler.AVOIDING_RECOMMENDED_MENU;
import static menu.handler.ErrorStateHandler.DISTINCT_RECOMMENDED_MENU;

import java.util.ArrayList;
import java.util.List;
import menu.domain.generator.MenuShuffleGenerator;
import menu.util.ResultConverter;
import menu.validator.AvoidingMenusValidator;
import menu.validator.CoachNameValidator;

public class Coach {
    private final String name;
    private final List<String> recommendedMenus;
    private List<String> avoidingMenus;

    public Coach(String name) {
        CoachNameValidator.validate(name);
        this.name = name;
        this.recommendedMenus = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void updateAvoidingMenus(final List<String> avoidingMenus) {
        AvoidingMenusValidator.validate(avoidingMenus);
        this.avoidingMenus = avoidingMenus;
    }

    public void pickMenuFrom(List<String> menus) {
        String menu = pickFrom(menus);
        checkRecommendedMenu(menu);
        recommendedMenus.add(menu);
    }

    @Override
    public String toString() {
        return ResultConverter.toString(name, recommendedMenus);
    }

    private String pickFrom(List<String> menus) {
        MenuShuffleGenerator menuShuffleGenerator = new MenuShuffleGenerator();
        return menuShuffleGenerator.generate(menus).get(0);
    }

    private void checkRecommendedMenu(String menu) {
        checkAvoidingRecommendedMenu(menu);
        checkDistinctRecommendedMenu(menu);
    }

    private void checkAvoidingRecommendedMenu(String menu) {
        if (avoidingMenus.contains(menu)) {
            throw AVOIDING_RECOMMENDED_MENU.getException();
        }
    }

    private void checkDistinctRecommendedMenu(String menu) {
        if (recommendedMenus.contains(menu)) {
            throw DISTINCT_RECOMMENDED_MENU.getException();
        }
    }
}
