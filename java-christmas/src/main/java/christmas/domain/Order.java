package christmas.domain;

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
        return quantity * Menu.getPrice(name);
    }
}
