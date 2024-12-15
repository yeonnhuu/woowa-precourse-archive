package christmas.controller;

import static christmas.constants.OrderConstants.*;
import static christmas.constants.OrdersConstants.*;

import christmas.domain.Cart;
import christmas.domain.Order;
import christmas.domain.Orders;
import christmas.domain.Visit;
import christmas.util.RepeatExecutor;
import christmas.validator.OrderValidator;
import christmas.validator.OrdersValidator;
import christmas.validator.VisitValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RepeatExecutor repeatExecutor = new RepeatExecutor(outputView);
    private final VisitValidator visitValidator = new VisitValidator();
    private final OrderValidator orderValidator = new OrderValidator();
    private final OrdersValidator ordersValidator = new OrdersValidator();

    private Visit visit;
    private Orders orders;
    private Cart cart;

    public void run() {
        displayStart();
        getVisit();
        getOrders();
        processOrders();
        displayEvent();
    }

    private void getVisit() {
        repeatExecutor.repeatUntilSuccess(() -> {
            String input = inputView.readVisit();
            visitValidator.validateVisit(input);
            visit = new Visit(Integer.parseInt(input));
            return null;
        });
    }

    private void getOrders() {
        repeatExecutor.repeatUntilSuccess(() -> {
            String input = inputView.readOrders();
            orders = new Orders();
            parseAndAddOrders(input);
            ordersValidator.validateCreatingOrder(orders);
            return null;
        });
    }

    private void processOrders() {
        cart = new Cart(orders);
        if (cart.applyDiscount()) {
            cart.calculatePromotion(visit);
        }
    }

    private void displayStart() {
        outputView.printWelcome();
    }

    private void displayEvent() {
        CartManager cartManager = new CartManager(cart);
        outputView.printEventHeader(visit.getDay());
        outputView.printEvent(cartManager);
    }

    private void parseAndAddOrders(String itemsLst) {
        String[] items = itemsLst.split(ORDERS_SEPARATOR);
        Order order;
        for (String item: items) {
            order = parseOrder(item);
            ordersValidator.validateAddingOrder(orders, order);
            orders.add(order);
        }
    }

    private Order parseOrder(String item) {
        String[] itemLst = item.split(ORDER_SEPARATOR);
        orderValidator.validateItemLst(itemLst);
        orderValidator.validateOrder(itemLst[0], itemLst[1]);
        return new Order(itemLst[0], Integer.parseInt(itemLst[1]));
    }
}
