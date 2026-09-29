package org.example;

import java.util.List;

/**
 * Calculate price in pence.
 */
public class Checkout {

    public int total(List<String> items) {
        validateItems(items);

        int apples = items.stream()
                .filter("Apple"::equals)
                .mapToInt(item -> 1)
                .sum();

        int oranges = items.stream()
                .filter("Orange"::equals)
                .mapToInt(item -> 1)
                .sum();

        return calculateApplePrice(apples)
                + calculateOrangePrice(oranges);
    }

    private int calculateApplePrice(int apples) {
        return (apples / 2 + apples % 2) * 60;
    }

    private int calculateOrangePrice(int oranges) {
        return (oranges / 3 * 2 + oranges % 3) * 25;
    }

    private void validateItems(List<String> items) {
        items.forEach(item -> {
            if (!item.equals("Apple") && !item.equals("Orange")) {
                throw new IllegalArgumentException("Unknown item: " + item);
            }
        });
    }
}