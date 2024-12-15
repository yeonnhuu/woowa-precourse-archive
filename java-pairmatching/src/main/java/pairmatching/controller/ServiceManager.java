package pairmatching.controller;

import static pairmatching.handler.ErrorHandler.UNAVAILABLE_MATCH;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.IOException;
import java.util.List;
import pairmatching.domain.Crews;
import pairmatching.domain.Feature;
import pairmatching.domain.mission.Mission;
import pairmatching.domain.Pairs;
import pairmatching.domain.Tracker;
import pairmatching.util.RepeatExecutor;
import pairmatching.validator.YesNoValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class ServiceManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RepeatExecutor repeatExecutor = new RepeatExecutor(outputView);
    private final YesNoValidator yesNoValidator = new YesNoValidator();
    private final Tracker tracker = new Tracker();
    private Crews crews;

    public void run() throws IOException {
        crews = new Crews();
        while (true) {
            Feature feature = getServiceFeature();
            if (feature.equals(Feature.QUIT)) {
                break;
            }
            processServiceFeature(feature);
        }
    }

    private Feature getServiceFeature() {
        return repeatExecutor.repeatUntilSuccess(() -> {
            String input = inputView.chooseServiceFeature();
            return Feature.findFeature(input);
        });
    }

    private boolean getMatchingRetry() {
        return repeatExecutor.repeatUntilSuccess(() -> {
            String input = inputView.readMatchingRetry();
            return yesNoValidator.validateAndParseYesNo(input);
        });
    }

    private void processServiceFeature(Feature feature) {
        if (feature.equals(Feature.MATCH) || feature.equals(Feature.VIEW)) {
            processServiceMatchView(feature);
        }
        if (feature.equals(Feature.INITIALIZE)) {
            processServiceInitialize();
        }
    }

    private void processServiceMatchView(Feature feature) {
        outputView.printServiceInfo();
        if (feature.equals(Feature.MATCH)) {
            processServiceMatch();
        }
        if (feature.equals(Feature.VIEW)) {
            processServiceView();
        }
    }

    private void processServiceMatch() {
        repeatExecutor.repeatUntilSuccess(() -> {
            Mission mission = getMission();
            List<String> crewNames = crews.filterCrewNames(mission);
            for (int tryCount = 0; tryCount <= 3; tryCount++) {
                Pairs pairs = processServicePairs(Randoms.shuffle(crewNames));
                if (tracker.addedPairs(mission.codeMission(), pairs)) {
                    outputView.printPairMatchingResult(pairs);
                    break;
                }
                checkContinueMatching(tryCount);
            }
            return null;
        });
    }

    private void processServiceView() {
        repeatExecutor.repeatUntilSuccess(() -> {
            Mission mission = getMission();
            Pairs pairs = tracker.searchPairs(mission.codeMission());
            outputView.printPairMatchingResult(pairs);
            return null;
        });
    }

    private void processServiceInitialize() {
        tracker.initialize();
        outputView.printTrackerInitialize();
    }

    private Pairs processServicePairs(List<String> crews) {
        Pairs pairs = new Pairs();
        List<String> names;
        for (int i = 0; i < crews.size()/2; i++) {
            names = crews.subList(2*i, 2*i+2);
            if (crews.size() % 2 != 0 && i == crews.size()/2 - 1) {
                names = crews.subList(2*i, 2*i+3);
            }
            pairs.addPair(names);
        }
        return pairs;
    }

    private Mission getMission() {
        return repeatExecutor.repeatUntilSuccess(() -> {
            String input = inputView.chooseServiceProperties();
            return Mission.findMission(input);
        });
    }

    private void checkContinueMatching(int tryCount) {
        if (tryCount == 3 || !getMatchingRetry()) {
            throw UNAVAILABLE_MATCH.getException();
        }
    }
}
