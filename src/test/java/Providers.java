import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
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

    public static Stream<Arguments> testIsValidTrueProvider (){
        return Stream.of(
                arguments("3 + 4 * 2 / (1 - 5)", true),
                arguments("4-5", true)
        );
    }


    public static Stream<Arguments> testIsExceptionProvider (){
        return Stream.of(
                arguments("Hello world! ", "Не верное выражение. Недопустимые символы."),
                arguments("4+)2", "Не верное выражение. Недопустимое положение операторов, или скобок."),
                arguments("4.+2", "Не верное выражение. Недопустимое положение десятичного разделителя."),
                arguments("4/000.00+1", "division by zero"),
                arguments("4+(2*(5-1)", "Ошибка в скобках.")
        );
    }

    public static Stream<Arguments> testParserProvider (){
        return Stream.of(
                arguments("3+4*2/(1-5)",  "[3, 4, 2, *, 1, 5, -, /, +]"),
                arguments("4+2", "[4, 2, +]")
        );
    }

    public static Stream<Arguments> testCalculateProvider (){
        return Stream.of(
                arguments("3,4,2,*,1,5,-,/,+",  "1"),
                arguments("4,2,+", "6")
        );
    }
}
