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
}
