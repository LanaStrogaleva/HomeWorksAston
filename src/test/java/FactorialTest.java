
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialTest {
    @DataProvider
    public Object[][] factorialTestData() {
        return new Object[][]{
                {0, 1},
                {1, 1},
                {2, 2},
                {3, 6},
                {4, 24},
                {5, 120},
        };
    }

    @Test(dataProvider = "factorialTestData")
    public void factorialTest(int n, int expected) {

        final int actual = Factorial.getFactorial(n);

        assertEquals(actual, expected, "Неверно вычислен факториал!");
    }

}
