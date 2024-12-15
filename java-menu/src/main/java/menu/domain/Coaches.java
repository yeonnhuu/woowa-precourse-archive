package menu.domain;

import static menu.handler.ErrorStateHandler.COACH_EXIST;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import menu.domain.enums.Category;
import menu.util.RepeatExecutor;
import menu.validator.CoachNamesValidator;

public class Coaches {
    private final List<Coach> coaches;
    private final RepeatExecutor repeatExecutor;

    public Coaches(List<String> coachNames, RepeatExecutor repeatExecutor) {
        CoachNamesValidator.validate(coachNames);
        this.coaches = initializeCoaches(coachNames);
        this.repeatExecutor = repeatExecutor;
    }

    public List<String> getCoachNames() {
        return coaches.stream()
                .map(Coach::getName)
                .collect(Collectors.toList());
    }

    public void updateCoachAvoidingMenus(String coachName, List<String> avoidingMenus) {
        Coach coach = findCoachBy(coachName);
        coach.updateAvoidingMenus(avoidingMenus);
    }

    public void pickMenusFrom(Category recommendedCategory) {
        List<String> menus = recommendedCategory.getMenus();
        for (Coach coach : coaches) {
            repeatExecutor.repeatUntilSuccess(() -> coach.pickMenuFrom(menus));
        }
    }

    @Override
    public String toString() {
        return coaches.stream()
                .map(Coach::toString)
                .collect(Collectors.joining());
    }

    private List<Coach> initializeCoaches(List<String> coachNames) {
        return coachNames.stream()
                .map(Coach::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private Coach findCoachBy(String coachName) {
        return coaches.stream()
                .filter(coach -> Objects.equals(coach.getName(), coachName))
                .findFirst()
                .orElseThrow(COACH_EXIST::getException);
    }
}
