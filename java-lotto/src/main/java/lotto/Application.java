package lotto;

import lotto.controller.LottoManager;

public class Application {
    public static void main(String[] args) {
        try {
            LottoManager lottoManager = new LottoManager();
            lottoManager.run();
        } catch (Exception e) {
            System.err.println("[ERROR] 프로그램 실행 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
