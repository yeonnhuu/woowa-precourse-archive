package racingcar.validator;

import static racingcar.handler.ErrorHandler.CAR_NAME_BLANK;
import static racingcar.handler.ErrorHandler.CAR_NAME_DISTINCT;
import static racingcar.handler.ErrorHandler.CAR_NAME_LENGTH;

import java.util.List;

public class CarNamesValidator {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    public List<String> validateAndParse(String input) {
        List<String> carNames = List.of(input.split(","));
        validate(carNames);
        return carNames;
    }

    private void validate(List<String> carNames) {
        for (String carName : carNames) {
            validateBlank(carName);
            validateLength(carName);
        }
        validateDisinct(carNames);
    }

    private void validateBlank(String carName) {
        if (carName.isBlank()) {
            throw CAR_NAME_BLANK.getException();
        }
    }

    private void validateLength(String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw CAR_NAME_LENGTH.getException();
        }
    }

    private void validateDisinct(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw CAR_NAME_DISTINCT.getException();
        }
    }
}
