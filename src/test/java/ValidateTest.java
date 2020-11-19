import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import service.Validate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidateTest {

    @ParameterizedTest
    @DisplayName("Тест Validate.clearString")
    @MethodSource("Providers#testClearStringProvider")
    void testClearString(String value, String expected) {
        assertThat(Validate.clearString(value), is(expected));
    }

    @ParameterizedTest
    @DisplayName("Тест Validate.isValidTrue")
    @MethodSource("Providers#testIsValidTrueProvider")
    void testIsValidTrue(String value, Boolean expected) {
        assertThat(Validate.isValid(Validate.clearString(value)), is(expected));
    }

    @ParameterizedTest
    @DisplayName("Тест Validate.isValidException")
    @MethodSource("Providers#testIsExceptionProvider")
    void testIsValid(String value, String expected) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Validate.isValid(Validate.clearString(value)));
        assertThat(exception.getMessage(), is(expected));
    }
}
