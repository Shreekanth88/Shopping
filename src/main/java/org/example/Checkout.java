package org.example;

import java.util.List;

/**
 * Calculate price in pence.
 */
public class Checkout {

    public int total(List<String> items) {
        long apples = items.stream()
                .filter("Apple"::equals)
                .count();

        long oranges = items.stream()
                .filter("Orange"::equals)
                .count();

        validateItems(items);

        return calculateApplePrice(apples)
                + calculateOrangePrice(oranges);
    }

    private int calculateApplePrice(long apples) {
        return (int) ((apples / 2 + apples % 2) * 60);
    }

    private int calculateOrangePrice(long oranges) {
        return (int) (oranges * 25);
    }

    private void validateItems(List<String> items) {
        items.forEach(item -> {
            if (!item.equals("Apple") && !item.equals("Orange")) {
                throw new IllegalArgumentException("Unknown item: " + item);
            }
        });
    }
}