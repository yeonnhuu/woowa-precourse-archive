package baseball.view;

public class OutputView {

    public void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGuessResult(int ball, int strike) {
        if (ball > 0 && strike > 0) {
            System.out.printf("%d볼 %d스트라이크%n", ball, strike);
        } else if (ball > 0 && strike == 0) {
            System.out.printf("%d볼%n", ball);
        } else if (ball == 0 && strike > 0) {
            System.out.printf("%d스트라이크%n", strike);
        } else if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
    }

    public void printFinish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
