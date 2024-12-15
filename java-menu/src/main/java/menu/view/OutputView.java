package menu.view;

public class OutputView {

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printRecommendStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printRecommendResult(String result) {
        System.out.println("\n메뉴 추천 결과입니다.");
        System.out.println(result);
    }

    public void printRecommendFinish() {
        System.out.println("추천을 완료했습니다.");
    }
}
