package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.handler.ValidationHandler;
import racingcar.view.InputView;

public class CarRegistrar {
    private static final String NAME_DELIMITER = ",";

    private final InputView inputView;
    private final Cars cars;
    private final ValidationHandler validationHandler = new ValidationHandler();

    public CarRegistrar(InputView inputView, Cars cars) {
        this.inputView = inputView;
        this.cars = cars;
    }

    void registerCars() {
        getCarNames().forEach(cars::add);
    }

    private List<String> getCarNames() {
        String input = inputView.readCarNames();
        validationHandler.validateInput(input);

        List<String> names = new ArrayList<>();
        for (String name : input.split(NAME_DELIMITER)) {
            validationHandler.validateName(name);
            names.add(name);
        }
        validationHandler.validateNames(names);
        return names;
    }
}
