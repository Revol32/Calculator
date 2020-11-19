import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import service.Parser;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ParserTest {
    @ParameterizedTest
    @DisplayName("Тест Parser.parser()")
    @MethodSource("Providers#testParserProvider")
    void testClearString(String value, String expected) {
        assertThat(Parser.parser(value).toString(), is(expected));
    }
}
