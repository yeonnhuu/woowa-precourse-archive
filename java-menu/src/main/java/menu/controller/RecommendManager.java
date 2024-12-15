package menu.controller;

import java.util.List;
import menu.domain.Coaches;
import menu.domain.Recommend;
import menu.domain.enums.Category;
import menu.domain.enums.Day;
import menu.util.RepeatExecutor;
import menu.view.InputView;
import menu.view.OutputView;

public class RecommendManager {
    private final InputView inputView;
    private final OutputView outputView;
    private final RepeatExecutor repeatExecutor;

    private Coaches coaches;
    private Recommend recommend;

    public RecommendManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.repeatExecutor = new RepeatExecutor(outputView);
    }

    public void run() {
        start();
        process();
        finish();
    }

    private void start() {
        outputView.printRecommendStart();
        coaches = repeatExecutor.repeatUntilSuccess(this::prepareCoaches);
        for (String coachName : coaches.getCoachNames()) {
            repeatExecutor.repeatUntilSuccess(() -> prepareAvoidingMenus(coachName));
        }
    }

    private void process() {
        recommend = new Recommend(coaches);
        for (Day day : Day.values()) {
            Category recommendedCategory = repeatExecutor.repeatUntilSuccess(recommend::recommendCategory);
            repeatExecutor.repeatUntilSuccess(() -> coaches.pickMenusFrom(recommendedCategory));
        }
    }

    private void finish() {
        outputView.printRecommendResult(recommend.toString());
        outputView.printRecommendFinish();
    }

    private Coaches prepareCoaches() {
        List<String> coachNames = inputView.readCoachNames();
        return new Coaches(coachNames, repeatExecutor);
    }

    private void prepareAvoidingMenus(String coachName) {
        List<String> avoidingMenus = inputView.readAvoidingMenus(coachName);
        coaches.updateCoachAvoidingMenus(coachName, avoidingMenus);
    }
}
