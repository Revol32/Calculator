import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Providers {
    private  Providers(){

    }

    public static Stream<Arguments> testConsolePrintResultProvider (){
        return Stream.of(
                arguments("", "Результат: \r\n"),
                arguments("4", "Результат: 4\r\n"),
                arguments("А что тут происходит?", "Результат: А что тут происходит?\r\n")
        );
    }

    public static Stream<Arguments> testConsoleReadProvider (){
        return Stream.of(
                arguments(" ", " "),
                arguments("4-5\n6+4", "4-5"),
                arguments("А что тут происходит?", "А что тут происходит?")
        );
    }

    public static Stream<Arguments> testClearStringProvider (){
        return Stream.of(
                arguments("3 + 4 * 2 / (1 - 5)", "3+4*2/(1-5)"),
                arguments("(-2)+(+2)", "(0-2)+(0+2)"),
                arguments("3 +() 4 * 2 / (1 - (-5))", "3+4*2/(1-(0-5))")
        );
    }

    public static Stream<Arguments> testIsValidProvider (){
        return Stream.of(
                arguments("", "Результат:"),
                arguments("4", "Результат: 4"),
                arguments("А что тут происходит?", "Результат: А что тут происходит?")
        );
    }

    public static Stream<Arguments> testIsBracketsNormalProvider (){
        return Stream.of(
                arguments("", "Результат:"),
                arguments("4", "Результат: 4"),
                arguments("А что тут происходит?", "Результат: А что тут происходит?")
        );
    }

    public static Stream<Arguments> zagotovka1 (){
        return Stream.of(
                arguments("", "Результат:"),
                arguments("4", "Результат: 4"),
                arguments("А что тут происходит?", "Результат: А что тут происходит?")
        );
    }

    public static Stream<Arguments> zagotovka2 (){
        return Stream.of(
                arguments("", "Результат:"),
                arguments("4", "Результат: 4"),
                arguments("А что тут происходит?", "Результат: А что тут происходит?")
        );
    }
}
