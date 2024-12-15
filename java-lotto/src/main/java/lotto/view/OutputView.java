package lotto.view;

import java.util.List;
import lotto.domain.Prize;

public class OutputView {

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printPurchaseLottos(List<List<Integer>> lottos) {
        System.out.printf("%n%d개를 구매했습니다.%n", lottos.size());
        lottos.forEach(System.out::println);
    }

    public void printPrizeStatistic(Prize prize) {
        printPrizeStatHeader();
        printPrizeStatRank(prize);
        printPrizeStatProfit(prize);
    }

    private void printPrizeStatHeader() {
        System.out.print("\n당첨 통계\n---");
    }

    private void printPrizeStatRank(Prize prize) {
        System.out.println(prize);
    }

    private void printPrizeStatProfit(Prize prize) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", prize.getTotalPrizeProfit());
    }
}
