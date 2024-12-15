package racingcar.domain;

public class Car {
    private final String name;
    private final CarState carState;

    public Car(String name) {
        this.name = name;
        this.carState = new CarState();
    }

    public String getName() {
        return name;
    }

    public int getCarState() {
        return carState.getPosition();
    }

    public void go() {
        carState.move();
    }

    public boolean hasTargetStateOf(int otherCarState) {
        return carState.hasPosition(otherCarState);
    }

    public String toString() {
        return name + " : " + carState;
    }
}
