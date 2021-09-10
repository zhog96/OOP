import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 1", "123.12, 15158.53"})
    void square_valid_radius_values(double side, double result) {
        Square square = new Square(side);
        assertEquals(result, square.square(), 0.01);
    }

    @ParameterizedTest
    @CsvSource({"-0.0000001", "-1", "-9999999"})
    void square_invalid_radius_values(double side) {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () ->
            new Square(side)
        );
        assertEquals(
                thrown.getMessage(),
                String.format("sides should be positive or zero, got (%f, %f)", side, side)
        );
    }
}
