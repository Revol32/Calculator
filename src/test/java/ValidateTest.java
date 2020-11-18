import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import service.Validate;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateTest {
    private static Validate validate;

    @BeforeAll
    static void initialize() {
        validate = new Validate();
    }

    @ParameterizedTest
    @DisplayName("Тест Validate.clearString()")
    @MethodSource("Providers#testClearStringProvider")
    void testClearString(String value, String expected) {
        assertThat(validate.clearString(value), is(expected));
    }

    @ParameterizedTest
    @DisplayName("Тест Validate.isValid()")
    @MethodSource("Providers#testIsValidProvider")
    void testIsValid(String value, String expected) {

        assertThat(value, is(expected));

    }

    @ParameterizedTest
    @DisplayName("Тест Validate.isBracketsNormal()")
    @MethodSource("Providers#testIsBracketsNormalProvider")
    void testIsBracketsNormal(String value, String expected) {

        assertThat(value, is(expected));

    }
}
