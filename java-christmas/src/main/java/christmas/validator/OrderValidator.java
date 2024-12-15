package christmas.validator;

import static christmas.constants.OrderConstants.*;
import static christmas.handler.ErrorHandler.INVALID_MENU;

import christmas.domain.Menu;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderValidator {

    public void validateItemLst(String[] lst) {
        validateItemLstSize(lst);
        validateItemLstQuantity(lst);
    }

    public void validateOrder(String name, String quantity) {
        validateOrderName(name);
        validateOrderQuantity(quantity);
    }

    private void validateItemLstSize(String[] lst) {
        if (lst.length != 2) {
            throw INVALID_MENU.getException();
        }
    }

    private void validateItemLstQuantity(String[] lst) {
        try {
            Integer.parseInt(lst[1]);
        } catch (NumberFormatException e) {
            throw INVALID_MENU.getException();
        }
    }

    private void validateOrderName(String value) {
        if (!Menu.getMenuNames().contains(value)) {
            throw INVALID_MENU.getException();
        }
    }

    private void validateOrderQuantity(String value) {
        Matcher matcher = Pattern.compile(ORDER_QUANTITY_REGEX).matcher(value);
        if (!matcher.find()) {
            throw INVALID_MENU.getException();
        }
    }
}
