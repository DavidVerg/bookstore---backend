package com.david.bookstore.domain.shoppingcart;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuantityTest {

    private DynamicTest IntToTest(Integer value) {
        String testName = "Value " + value + " should be valid";
        return DynamicTest.dynamicTest(testName, () -> {

            // act
            Quantity quantity = new Quantity(value);

            // assert
            assertEquals(value, quantity.asInt());
        });
    }


    @TestFactory
    @DisplayName("1 until 10 is a valid quantity")
    Stream<DynamicTest> validValues() {
        return IntStream.rangeClosed(1, 10)
                .mapToObj(value -> this.IntToTest(value));
    }

    @Test
    @DisplayName("Quantity null throws an error")
    void nullCheck() {
        // arrange
        Integer value = null;

        // act
        Executable executable = () -> new Quantity(value);


        // assert
        assertThrows(NullPointerException.class, executable);
    }


    @Test
    @DisplayName("Invalid quantity throws an error")
    void illegalValueCheck() {
        // arrange
        Integer value = -7;

        // act
        Executable executable = () -> new Quantity(value);


        // assert
        assertThrows(IllegalArgumentException.class, executable);
    }

}
