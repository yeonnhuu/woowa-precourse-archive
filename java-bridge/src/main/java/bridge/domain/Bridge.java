package bridge.domain;

import bridge.domain.generator.BridgeRandomNumberGenerator;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(int size) {
        this.bridge = createBridge(size);
    }

    public List<String> getSteps() {
        return bridge;
    }

    private List<String> createBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(size);
    }
}
