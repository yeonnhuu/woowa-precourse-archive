package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Integer> answer;
    private int ball;
    private int strike;

    public Game() {
        this.answer = getAnswer();
        this.ball = 0;
        this.strike = 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void processGuess(List<Integer> numbers) {
        ball = 0;
        strike = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            if (number == answer.get(i)) {
                strike++;
                continue;
            }
            if (answer.contains(number)) {
                ball++;
            }
        }
    }

    public boolean isWrongGuess() {
        if (ball == 0 && strike == 3) {
            return false;
        }
        return true;
    }

    private List<Integer> getAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
