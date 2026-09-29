package org.example;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class CheckoutTest {

    private final Checkout checkout = new Checkout();

    @Test
    void emptyBasketCostsNothing() {
        assertEquals(0, checkout.total(List.of()));
    }

    @Test
    void oneAppleCosts60p() {
        assertEquals(60, checkout.total(List.of("Apple")));
    }

    @Test
    void oneOrangeCosts25p() {
        assertEquals(25, checkout.total(List.of("Orange")));
    }

    @Test
    void mixedBasketCostsCorrectAmount() {
        assertEquals(
                205,
                checkout.total(List.of("Apple", "Apple", "Orange", "Apple"))
        );
    }
}
