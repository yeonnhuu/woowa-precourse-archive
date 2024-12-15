package christmas.controller;

import christmas.domain.Event;
import christmas.domain.Orders;
import christmas.util.RepeatExecutor;
import christmas.validator.EventDayValidator;
import christmas.validator.EventOrdersValidator;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class EventManager {
    private final InputView inputView;
    private final OutputView outputView;
    private final RepeatExecutor repeatExecutor;

    private Event event;

    public EventManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.repeatExecutor = new RepeatExecutor(outputView);
    }

    public void run() {
        start();
        process();
        finish();
    }

    private void start() {
        outputView.printEventStart();
        int day = repeatExecutor.repeatUntilSuccess(this::prepareEventDay);
        Orders orders = repeatExecutor.repeatUntilSuccess(this::prepareEventOrders);
        event = new Event(day, orders);
    }

    private void process() {
        event.calculatePromotion();
    }

    private void finish() {
        outputView.printEventResult(event.getDay(), event.toString());
    }

    private int prepareEventDay() {
        String input = inputView.readEventDay();
        EventDayValidator eventDayValidator = new EventDayValidator();
        return eventDayValidator.validateAndParse(input);
    }

    private Orders prepareEventOrders() {
        String input = inputView.readOrders();
        EventOrdersValidator eventOrdersValidator = new EventOrdersValidator();
        Map<String, Integer> ordersMap = eventOrdersValidator.validateAndParse(input);
        return createEventOrders(ordersMap);
    }

    private Orders createEventOrders(Map<String, Integer> ordersMap) {
        Orders eventOrders = new Orders();
        for (Map.Entry<String, Integer> entry : ordersMap.entrySet()) {
            eventOrders.updateOrders(entry.getKey(), entry.getValue());
        }
        return eventOrders;
    }
}
