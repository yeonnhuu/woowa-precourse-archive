package vendingmachine.controller;

import java.util.List;
import vendingmachine.domain.BalanceCoins;
import vendingmachine.domain.PurchaseMoney;
import vendingmachine.domain.VendingCoins;
import vendingmachine.domain.VendingMoney;
import vendingmachine.domain.VendingProduct;
import vendingmachine.domain.VendingProducts;
import vendingmachine.handler.Validator;
import vendingmachine.util.RepeatExecutor;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Validator validator = new Validator();
    private final RepeatExecutor repeatExecutor = new RepeatExecutor(outputView);

    private VendingMoney vendingMoney;
    private VendingCoins vendingCoins;
    private VendingProducts vendingProducts;
    private PurchaseMoney purchaseMoney;

    public void run() {
        getVendingMoney();
        getVendingCoins();
        getVendingProducts();
        getPurchaseMoney();
        processPurchase();
    }

    private void getVendingMoney() {
        repeatExecutor.repeatUntilSuccess(() -> {
            String input = inputView.readVendingMoney();
            int money = validator.validateMoney(input);
            vendingMoney = new VendingMoney(money);
            return null;
        });
    }

    private void getVendingCoins() {
        vendingCoins = new VendingCoins();
        vendingCoins.calculateCoins(vendingMoney.getAmount());
        outputView.printVendingCoins(vendingCoins.toString());
    }

    private void getVendingProducts() {
        repeatExecutor.repeatUntilSuccess(() -> {
            String input = inputView.readVendingProducts();
            List<List<String>> products = validator.validateVendingProducts(input);
            vendingProducts = new VendingProducts();
            processVendingProducts(products);
            return null;
        });
    }

    private void getPurchaseMoney() {
        repeatExecutor.repeatUntilSuccess(() -> {
            String input = inputView.readPurchaseMoney();
            int money = validator.validateMoney(input);
            purchaseMoney = new PurchaseMoney(money);
            return null;
        });
    }

    private void processPurchase() {
        int minimumPrice = vendingProducts.getPrice().stream().mapToInt(Integer::intValue).min().orElse(purchaseMoney.getAmount()+1);
        int totalQuantity = vendingProducts.getQuantity().stream().mapToInt(Integer::intValue).sum();
        while (minimumPrice <= purchaseMoney.getAmount() || totalQuantity == 0) {
            getPurchaseProduct();
        }
        processBalance();
    }

    private void processBalance() {
        outputView.printPurchaseMoney(purchaseMoney.getAmount());
        BalanceCoins balanceCoins = new BalanceCoins();
        balanceCoins.calculateCoins(vendingCoins, purchaseMoney.getAmount());
        outputView.printBalanceCoins(balanceCoins.toString());
    }

    private void processVendingProducts(List<List<String>> products) {
        for (List<String> product : products) {
            String name = product.get(0);
            int price = Integer.parseInt(product.get(1));
            int quantity = Integer.parseInt(product.get(2));
            VendingProduct vendingProduct = new VendingProduct(name, price, quantity);
            vendingProducts.addProduct(vendingProduct);
        }
    }

    private void getPurchaseProduct() {
        repeatExecutor.repeatUntilSuccess(() -> {
            outputView.printPurchaseMoney(purchaseMoney.getAmount());
            String input = inputView.readPurchaseProduct();
            VendingProduct product = vendingProducts.getVendingProductByName(input);
            product.decreaseQuantity();
            purchaseMoney.decreaseAmount(product.getPrice());
            return null;
        });
    }
}
