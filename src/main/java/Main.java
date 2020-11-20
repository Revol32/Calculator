import service.*;

import static service.Parser.parser;

public class Main {
    private static String expression;

    public static void main(String[] args) {
        Console console = new Console();
        Calculate calculate = new Calculate();
        expression = console.read();
        expression = Validate.clearString(expression);
        if (Validate.isValid(expression)) {
            console.printResult(calculate.calculate(parser(expression)));
        }
    }
}
