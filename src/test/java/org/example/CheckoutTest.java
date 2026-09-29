package org.example;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void unknownItemIsRejected() {
        assertThrows(
                IllegalArgumentException.class,
                () -> checkout.total(List.of("Banana"))
        );
    }

    @Test
    void twoApplesCost60pWithBuyOneGetOneFree() {
        assertEquals(60, checkout.total(List.of("Apple", "Apple")));
    }

    @Test
    void threeApplesCost120p() {
        assertEquals(
                120,
                checkout.total(List.of("Apple", "Apple", "Apple"))
        );
    }
}
