package store.util;

import static store.handler.ErrorHandler.INVALID_INPUT;
import static store.handler.ErrorHandler.PRODUCT_NULL;
import static store.handler.ErrorHandler.QUANTITY_EXCEED;

import java.util.List;
import store.domain.Products;

public class Validator {

    public static void validateItemGroupBracket(String group) {
        if (!group.startsWith("[") || !group.endsWith("]")) {
            throw INVALID_INPUT.getException();
        }
    }

    public static void validateItemGroupSize(List<String> group) {
        if (group.size() != 2) {
            throw INVALID_INPUT.getException();
        }
    }

    public static String validateAndExtractName(Products products, String name) {
        if (!products.hasProduct(name)) {
            throw PRODUCT_NULL.getException();
        }
        return name;
    }

    public static int validateAndExtractQuantity(Products products, String name, String quantityStr) {
        try {
            int quantity = Integer.parseInt(quantityStr);
            validateItemQuantity(products, name, quantity);
            return quantity;
        } catch (NumberFormatException e) {
            throw INVALID_INPUT.getException();
        }
    }

    private static void validateItemQuantity(Products products, String name, int quantity) {
        if (!products.hasEnoughQuantity(name, quantity)) {
            throw QUANTITY_EXCEED.getException();
        }
    }

    public static void validateYesNoInput(String input) {
        if (!input.equals("Y") && !input.equals("N")) {
            throw INVALID_INPUT.getException();
        }
    }
}
