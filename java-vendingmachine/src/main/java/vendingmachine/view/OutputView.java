package vendingmachine.view;

public class OutputView {

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printVendingCoins(String vendingCoins) {
        System.out.println("\n자판기가 보유한 동전");
        System.out.println(vendingCoins);
    }

    public void printPurchaseMoney(int purchaseMoney) {
        System.out.printf("\n투입 금액: %d원%n", purchaseMoney);
    }

    public void printBalanceCoins(String balance) {
        System.out.println("잔돈");
        System.out.println(balance);
    }
}
