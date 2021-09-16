package com.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 3.14", "123.12, 47621.94"})
    void shouldCalculateArea(double radius, double result) {
        Circle circle = new Circle(radius);
        assertEquals(result, circle.calculateArea(), 0.01);
    }

    @ParameterizedTest
    @CsvSource({"-0.0000001", "-1", "-9999999"})
    void shouldThrowExceptionCalculatingArea(double radius) {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () ->
            new Circle(radius)
        );
        assertEquals(
                thrown.getMessage(),
                String.format("radius should be positive or zero, got %f", radius)
        );
    }
}
