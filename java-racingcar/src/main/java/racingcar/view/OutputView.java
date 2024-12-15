package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String PROCESS_BAR = "-";
    private static final String WINNER_DELIMITER = ", ";

    public void printProcessHeader() {
        System.out.println("\n실행 결과");
    }

    public void printProcessResult(List<String> names, List<Integer> positions) {
        System.out.println();
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%s : %s\n", names.get(i), PROCESS_BAR.repeat(positions.get(i)));
        }
    }

    public void printWinner(List<String> names) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n최종 우승자 : ");
        for (String name : names) {
            sb.append(name).append(WINNER_DELIMITER);
        }
        System.out.println(sb.deleteCharAt((sb.length() - 2)));
    }
}
