package com.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @ParameterizedTest
    @CsvSource({"0, 1, 0", "1, 0, 0", "1, 1, 1", "11.11, 10.10, 112.211", "10.10, 11.11, 112.211"})
    void shouldCalculateArea(double width, double height, double result) {
        Rectangle rectangle = new Rectangle(width, height);
        assertEquals(result, rectangle.calculateArea(), 0.01);
    }

    @ParameterizedTest
    @CsvSource({"-0.0001, 0", "0, -1", "1, -1", "-1, 1", "-99999, -99999"})
    void shouldThrowExceptionCalculatingArea(double width, double height) {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () ->
            new Rectangle(width, height)
        );
        assertEquals(
                thrown.getMessage(),
                String.format("sides should be positive or zero, got (%f, %f)", width, height)
        );
    }
}
