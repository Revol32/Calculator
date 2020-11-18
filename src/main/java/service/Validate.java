package service;

import java.util.regex.Matcher;

import static java.util.regex.Pattern.compile;

public class Validate {
    public static String clearString(String expression) {
        expression = expression.replaceAll(" ", "")
                .replaceAll("\\(-", "(0-")
                .replaceAll("\\(\\+", "(0+")
                .replaceAll("()", "");
        System.out.println(expression);
        return expression;
    }

    public static Boolean isValid(String expression) {
        if (expression.length() == 0) {
            System.out.println("Введена пустая строка.");
            expression = new Console().read();
            return isValid(expression);
        }
        Matcher matcher = compile("[^\\d" + Operators.getOperatorsToString() + "\\.]").matcher(expression);
        if (matcher.find()) {
            throw new IllegalArgumentException("Не верное выражение. Недопустимые символы.");
        }
        matcher = compile("[" + Operators.getOperatorsToStringWishOutBrackets() + "]" + "[" + Operators.getOperatorsToStringWishOutBrackets() + ")]|" +
                "^[" + Operators.getOperatorsToStringWishOutBrackets() + "]|[" + Operators.getOperatorsToStringWishOutBrackets() + "]$|" +
                "[(][" + Operators.getOperatorsHighPriorityToString() + "]").matcher(expression);
        if (matcher.find()) {
            throw new IllegalArgumentException("Не верное выражение. Недопустимое положение операторов, или скобок.");
        }
        matcher = compile("[\\.][" + Operators.getOperatorsToString() + "]|[" + Operators.getOperatorsToString() + "][\\.]").matcher(expression);
        if (matcher.find()) {
            throw new IllegalArgumentException("Не верное выражение. Недопустимое положение десятичного разделителя.");
        }
        matcher = compile("[\\/][0][" + Operators.getOperatorsToString() + "]").matcher(expression);
        if (matcher.find()) {
            throw new IllegalArgumentException("division by zero");
        }
        if (!isBracketsNormal(expression)) {
            throw new IllegalArgumentException("Ошибка в скобках.");
        }
        return true;
    }

    private static boolean isBracketsNormal(String expression) {
        expression = expression.replaceAll("[^()]", "");
        while (expression.contains("(") && expression.contains(")")) {
            expression = expression.replace("()", "");
        }
        return expression.isEmpty();
    }
}
