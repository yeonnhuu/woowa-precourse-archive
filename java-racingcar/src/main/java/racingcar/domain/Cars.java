package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void registerCar(String name) {
        this.cars.add(new Car(name));
    }

    public void race() {
        for (Car car : cars) {
            car.go();
        }
    }

    public List<String> findWinners() {
        int maxCarState = findMaxCarState();
        return cars.stream()
                .filter(car -> car.hasTargetStateOf(maxCarState))
                .map(Car::getName)
                .toList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    private int findMaxCarState() {
        return cars.stream()
                .mapToInt(Car::getCarState)
                .max()
                .orElse(0);
    }
}
