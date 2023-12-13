import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;


public class FactorialTest {
    static Stream<Arguments> factorialTestData() {
        return Stream.of(
                arguments(0, 1),
                arguments(1, 1),
                arguments(2, 2),
                arguments(3, 6),
                arguments(4, 24),
                arguments(5, 120)
        );
    }
    @DisplayName("Правильно считается факториал")
    @ParameterizedTest
    @MethodSource("factorialTestData")

    public void factorialTest(int n, int expected) {

        int actual = Factorial.getFactorial(n);

        Assertions.assertEquals(expected, actual, "Неверно вычислен факториал!");
    }

}
