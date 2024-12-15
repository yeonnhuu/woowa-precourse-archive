package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private final List<Order> orders;

    public Orders() {
        this.orders = new ArrayList<>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<String> getName() {
        return orders.stream()
                .map(Order::getName)
                .toList();
    }

    public List<Integer> getQuantity() {
        return orders.stream()
                .map(Order::getQuantity)
                .toList();
    }

    public void add(Order order) {
        orders.add(order);
    }

    public int getCourseQuantity(MenuCourse course) {
        return orders.stream()
                .filter(order -> Menu.getMenuNamesByCourse(course).contains(order.getName()))
                .mapToInt(Order::getQuantity)
                .sum();
    }
}
