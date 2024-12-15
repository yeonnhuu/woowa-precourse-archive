package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String chooseServiceFeature() {
        String message = """
                기능을 선택하세요.
                1. 페어 매칭
                2. 페어 조회
                3. 페어 초기화
                Q. 종료""";
        return prompt(message);
    }

    public String chooseServiceProperties() {
        String message = """
                \n과정, 레벨, 미션을 선택하세요.
                ex) 백엔드, 레벨1, 자동차경주""";
        return prompt(message);
    }

    public String readMatchingRetry() {
        String message = """
                \n매칭 정보가 있습니다. 다시 매칭하시겠습니까?
                네 | 아니오""";
        return prompt(message);
    }

    private String prompt(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
