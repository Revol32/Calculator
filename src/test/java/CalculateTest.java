import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import service.Calculate;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CalculateTest {
    @ParameterizedTest
    @DisplayName("Тест Calculate.calculate()")
    @MethodSource("Providers#testCalculateProvider")
    void testClearString(String value, String expected) {
        assertThat(Calculate.calculate(new ArrayList<String>(Arrays.asList(value.split(",")))), is(expected));
    }
}
