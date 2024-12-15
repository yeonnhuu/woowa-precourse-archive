package subway.domain.menu;

import static subway.handler.ErrorHandler.INVALID_INPUT;

import java.util.Arrays;

public enum MainOption {
    ROUTE_VIEW("1", "경로 조회"),
    QUIT("Q", "종료");

    private final String key;
    private final String name;

    MainOption(final String key, final String name) {
        this.key = key;
        this.name = name;
    }

    public static String toInfoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n## 메인 화면").append("\n");
        for (MainOption mainMenu : MainOption.values()) {
            sb.append(mainMenu.key).append(". ").append(mainMenu.name).append("\n");
        }
        return sb.toString();
    }

    public static MainOption findMainOption(String key) {
        return Arrays.stream(MainOption.values())
                .filter(mainOption -> mainOption.key.equals(key))
                .findFirst()
                .orElseThrow(INVALID_INPUT::getException);
    }
}
