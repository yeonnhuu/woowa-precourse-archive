package christmas.validator;

import static christmas.handler.ErrorArgumentHandler.INVALID_ORDER;

import christmas.domain.enums.Course;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class EventOrdersValidator {
    private Map<String, Integer> ordersMap;
    
    public Map<String, Integer> validateAndParse(String input) {
        ordersMap = new TreeMap<>();
        List<String> ordersItems = Arrays.asList(input.split(","));
        validateOrdersItems(ordersItems);
        for (String  items : ordersItems) {
            validateAndParseOrderItems(items);
        }
        validateOrders();
        return ordersMap;
    }

    private void validateAndParseOrderItems(String items) {
        List<String> orderItems = Arrays.asList(items.split("-"));
        validateOrderItems(orderItems);
        ordersMap.put(orderItems.getFirst(), Integer.parseInt(orderItems.getLast()));
    }
    
    // FIXME : Orders Items
    private void validateOrdersItems(List<String> ordersItems) {
        validateOrdersSize(ordersItems);
    }

    // Orders Items - size
    private void validateOrdersSize(List<String> ordersItems) {
        if (ordersItems.isEmpty()) {
            throw INVALID_ORDER.getException();
        }
    }

    // FIXME : Order Items
    public void validateOrderItems(List<String> orderItems) {
        validateOrderSize(orderItems);
        validateOrderName(orderItems.getFirst());
        validateOrderQuantity(orderItems.getLast());
    }

    // Order Items - size
    private void validateOrderSize(List<String> items) {
        if (items.size() != 2) {
            throw INVALID_ORDER.getException();
        }
    }
    
    // Order Items - name
    private void validateOrderName(String name) {
        validateNameExist(name);
        validateNameDistinct(name);
    }
    
    private void validateNameExist(String name) {
        List<String> courseMenuNames = Course.getAllMenuNames();
        if (!courseMenuNames.contains(name)) {
            throw INVALID_ORDER.getException();
        }
    }
    
    private void validateNameDistinct(String name) {
        if (ordersMap.containsKey(name)) {
            throw INVALID_ORDER.getException();
        }
    }
    
    // Order Items - quantity
    private void validateOrderQuantity(String quantity) {
        validateQuantityDigit(quantity);
        validateQuantityRange(quantity);
    }

    private void validateQuantityDigit(String quantity) {
        try {
            Integer.parseInt(quantity);
        } catch (NumberFormatException e) {
            throw INVALID_ORDER.getException();
        }
    }

    private void validateQuantityRange(String quantity) {
        if (Integer.parseInt(quantity) < 1) {
            throw INVALID_ORDER.getException();
        }
    }

    // FIXME : Orders
    private void validateOrders() {
        validateOrdersName();
        validateOrdersQuantity();
    }

    private void validateOrdersName() {
        Set<String> beverageMenus = Course.BEVERAGES.getMenuNames();
        for (String orderName : ordersMap.keySet()) {
            if (!beverageMenus.contains(orderName)) {
                return;
            }
        }
        throw INVALID_ORDER.getException();
    }

    private void validateOrdersQuantity() {
        int totalQuantity = ordersMap.values().stream().mapToInt(Integer::intValue).sum();
        if (totalQuantity > 20) {
            throw INVALID_ORDER.getException();
        }
    }
}
