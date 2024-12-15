package christmas.domain;

import christmas.domain.enums.Course;

public class Order {
    private final String name;
    private final int quantity;

    public Order(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        int menuPrice = Course.getMenuPrice(name);
        return quantity * menuPrice;
    }

    @Override
    public String toString() {
        return String.format("%s %d개", name, quantity);
    }
}
