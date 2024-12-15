package lotto.view;

public class OutputView {

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printPurchaseLottos(String purchasedLottos) {
        System.out.println(purchasedLottos);
    }

    public void printPrizeStatistic(String prizeStatistics) {
        System.out.print("\n당첨 통계\n---");
        System.out.println(prizeStatistics);
    }

    public void printPrizeProfit(String prizeProfit) {
        System.out.println(prizeProfit);
    }
}
