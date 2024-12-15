package bridge.domain;

import java.util.ArrayList;
import java.util.List;

// 다리 건너기 게임을 관리하는 클래스
public class BridgeGame {

    private final Bridge bridge;
    private List<String> bridgeGame;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.bridgeGame = new ArrayList<>();
    }

    public List<String> getSteps() {
        return bridgeGame;
    }

    // 사용자가 칸을 이동할 때 사용하는 메서드
    public boolean move(String command) {
        bridgeGame.add(command);
        return canStep(command, bridgeGame.size()-1);
    }

    // 사용자가 게임을 다시 시도할 때 사용하는 메서드
    public void retry() {
        this.bridgeGame = new ArrayList<>();
    }

    private boolean canStep(String command, int index) {
        List<String> answer = bridge.getSteps();
        if (answer.get(index).equals(command)) {
            return true;
        }
        return false;
    }

    public boolean isSuccessful() {
        List<String> answer = bridge.getSteps();
        return bridgeGame.equals(answer);
    }
}
