import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import service.Console;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConsoleTest {
    private static Console console;

    @BeforeAll
    static void initialize(){
        console= new Console();
    }

    @ParameterizedTest
    @DisplayName("Тест Console.consolePrint()")
    @MethodSource("Providers#testConsolePrintResultProvider")
    void testConsolePrintResult (String value,String expected){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        console.printResult(value);
        assertThat (output.toString(),is(expected));
        System.setOut(System.out);
    }

    @ParameterizedTest
    @DisplayName("Тест Console.read()")
    @MethodSource("Providers#testConsoleReadProvider")
    void testConsoleRead (String value,String expected){
        System.setIn(new ByteArrayInputStream(value.getBytes()));
        assertThat(console.read(),is(expected));
        System.setIn(System.in);
    }

}
