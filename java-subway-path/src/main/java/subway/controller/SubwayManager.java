package subway.controller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import subway.domain.RouteRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.menu.MainOption;
import subway.domain.menu.RouteOption;
import subway.util.RepeatExecutor;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayManager {
    private final InputView inputView;
    private final OutputView outputView;
    private final RepeatExecutor repeatExecutor;
    private final RouteRepository routeRepository;

    public SubwayManager(Scanner scanner) throws IOException {
        inputView = new InputView(scanner);
        outputView = new OutputView();
        repeatExecutor = new RepeatExecutor(outputView);
        routeRepository = new RouteRepository();
    }

    public void run() {
        while (true) {
            MainOption mainOption = getMainOption();
            if (mainOption == MainOption.QUIT) {
                break;
            }
            processRouteOption();
        }
    }

    private MainOption getMainOption() {
        return repeatExecutor.repeatUntilSuccess(() -> {
            String input = inputView.readMainOption();
            return MainOption.findMainOption(input);
        });
    }

    private RouteOption getRouteOption() {
        return repeatExecutor.repeatUntilSuccess(() -> {
            String input = inputView.readRouteOption();
            return RouteOption.findRouteOption(input);
        });
    }

    private void processRouteOption() {
        repeatExecutor.repeatUntilSuccess(() -> {
            RouteOption routeOption = getRouteOption();
            if (routeOption == RouteOption.BACK_TO_MAIN_MENU) {
                return null;
            }
            processShortestRoute(routeOption);
            return null;
        });
    }

    private void processShortestRoute(RouteOption routeOption) {
        StationRepository stationRepository = new StationRepository();
        Station start = stationRepository.findStationByName(inputView.readStartStation());
        Station finish = stationRepository.findStationByName(inputView.readFinishStation());
        routeRepository.calculateShortestRoute(start, finish, routeOption);

        int distance = routeRepository.findRouteWeight(RouteOption.SHORTEST_DISTANCE);
        int duration = routeRepository.findRouteWeight(RouteOption.SHORTEST_DURATION);
        List<String> stations = routeRepository.findRouteStations();
        outputView.printViewResult(distance, duration, stations);
    }
}
