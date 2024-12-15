package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class WinnerProcessor {
    private final Cars cars;

    public WinnerProcessor(Cars cars) {
        this.cars = cars;
    }

    List<String> getWinnerNames() {
        int maxPosition = getMaxPosition();
        return cars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int getMaxPosition() {
        return cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
