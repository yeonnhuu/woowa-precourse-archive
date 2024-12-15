package bridge.view;

import static bridge.util.Constants.BRIDGE_CANT_STEP;
import static bridge.util.Constants.BRIDGE_CAN_STEP;
import static bridge.util.Constants.BRIDGE_DELIMITER;
import static bridge.util.Constants.BRIDGE_END;
import static bridge.util.Constants.BRIDGE_NOT_STEP;
import static bridge.util.Constants.BRIDGE_START;

import bridge.domain.enums.MoveOptions;
import java.util.ArrayList;
import java.util.List;

// 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
public class OutputView {

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printGameStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    // 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
    public void printMap(List<String> answer, List<String> game) {
        List<String> upMap = new ArrayList<>();
        List<String> downMap = new ArrayList<>();
        for (int i = 0; i < game.size(); i++) {
            upMap.add(checkStep(game.get(i), answer.get(i), MoveOptions.U.name()));
            downMap.add(checkStep(game.get(i), answer.get(i), MoveOptions.D.name()));
        }
        printFormattedMap(upMap, downMap);
    }

    private void printFormattedMap(List<String> upMap, List<String> downMap) {
        System.out.println(formatMap(upMap));
        System.out.println(formatMap(downMap));
        System.out.println();
    }

    private String formatMap(List<String> map) {
        return BRIDGE_START + String.join(BRIDGE_DELIMITER, map) + BRIDGE_END;
    }

    private String checkStep(String gameStep, String answerStep, String optionStep) {
        if (gameStep.equals(optionStep)) {
            if (gameStep.equals(answerStep)) {
                return BRIDGE_CAN_STEP;
            }
            return BRIDGE_CANT_STEP;
        }
        return BRIDGE_NOT_STEP;
    }

    // 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
    public void printResultHeader() {
        System.out.println("최종 게임 결과");
    }

    public void printResultSuccess(boolean success) {
        System.out.printf("게임 성공 여부: %s%n", parseSuccess(success));
    }

    private String parseSuccess(boolean success) {
        if (success) {
            return "성공";
        }
        return "실패";
    }

    public void printResultTryCount(int tryCount) {
        System.out.printf("총 시도한 횟수: %d%n", tryCount);
    }
}
