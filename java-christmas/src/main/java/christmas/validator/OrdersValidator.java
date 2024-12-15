package christmas.validator;

import static christmas.constants.OrdersConstants.*;
import static christmas.handler.ErrorHandler.INVALID_MENU;

import christmas.domain.Menu;
import christmas.domain.MenuCourse;
import christmas.domain.Order;
import christmas.domain.Orders;
import java.util.List;
import java.util.Set;

public class OrdersValidator {

    public void validateAddingOrder(Orders orders, Order order) {
        if (orders.getName().contains(order.getName())) {
            throw INVALID_MENU.getException();
        }
    }

    public void validateCreatingOrder(Orders orders) {
        validateOnlyBeverageOrders(orders);
        validateTotalOrderQuantity(orders);
    }

    private void validateOnlyBeverageOrders(Orders orders) {
        List<String> orderNames = orders.getName();
        Set<String> courseNames = Menu.getMenuNamesByCourse(MenuCourse.BEVERAGES);
        if (courseNames.containsAll(orderNames)) {
            throw INVALID_MENU.getException();
        }
    }

    private void validateTotalOrderQuantity(Orders orders) {
        List<Integer> quantities = orders.getQuantity();
        if (quantities.stream().mapToInt(Integer::intValue).sum() > ORDERS_QUANTITY_MAX) {
            throw INVALID_MENU.getException();
        }
    }
}
