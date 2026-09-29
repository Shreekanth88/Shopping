package org.example;

import java.util.List;

/**
 * Calculate price in pence.
 */
public class Checkout {

    public int total(List<String> items) {
        return items.stream()
                .mapToInt(this::calculatePrice)
                .sum();
    }

    private int calculatePrice(String item) {
        return switch (item) {
            case "Apple" -> 60;
            case "Orange" -> 25;
            default -> throw new IllegalArgumentException("Unknown item: " + item);
        };
    }
}