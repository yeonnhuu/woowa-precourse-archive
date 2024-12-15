package vendingmachine.handler;

import static vendingmachine.handler.ErrorHandler.INPUT_MONEY;
import static vendingmachine.handler.ErrorHandler.INPUT_VENDING_PRODUCTS;
import static vendingmachine.handler.ErrorHandler.VENDING_PRODUCT_PRICE;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Validator {
    private static final String MONEY_PATTERN = "^\\d+$";
    private static final int VENDING_PRICE_MIN = 100;
    private static final int VENDING_PRICE_UNIT = 10;

    public int validateMoney(String value) {
        Matcher matcher = Pattern.compile(MONEY_PATTERN).matcher(value);
        if (!matcher.matches()) {
            throw INPUT_MONEY.getException();
        }
        return Integer.parseInt(value);
    }

    public List<List<String>> validateVendingProducts(String value) {
        return Arrays.stream(value.split(";"))
                .map(this::validateAndParseProduct)
                .collect(Collectors.toList());
    }

    private List<String> validateAndParseProduct(String group) {
        group = group.replace("[", "").replace("]", "");
        List<String> items = Arrays.asList(group.split(","));
        validateProductSize(items);
        validateProductData(items);
        return items;
    }

    private void validateProductSize(List<String> items) {
        if (items.size() != 3) {
            throw INPUT_VENDING_PRODUCTS.getException();
        }
    }

    private void validateProductData(List<String> items) {
        try {
            validateName(items.get(0));
            validatePrice(Integer.parseInt(items.get(1)));
            validateQuantity(Integer.parseInt(items.get(2)));
        } catch (NumberFormatException e) {
            throw INPUT_VENDING_PRODUCTS.getException();
        }
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw INPUT_VENDING_PRODUCTS.getException();
        }
    }

    private void validatePrice(int price) {
        if (price < VENDING_PRICE_MIN || price % VENDING_PRICE_UNIT != 0) {
            throw VENDING_PRODUCT_PRICE.getException();
        }
    }

    private void validateQuantity(int quantity) {
        if (quantity < 0) {
            throw INPUT_VENDING_PRODUCTS.getException();
        }
    }
}
