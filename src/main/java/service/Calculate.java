package service;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Calculate {
    public String calculate(ArrayList<String> expressionList) {
        double result = 0;
        for (int i = 0; expressionList.size() > i; i++) {
            if (expressionList.get(i).matches("[" + Operators.getOperatorsToStringWishOutBrackets() + "]")) {
                switch (expressionList.get(i)) {
                    case "+" -> result = Double.parseDouble(expressionList.get(i - 2)) + Double.parseDouble(expressionList.get(i - 1));
                    case "-" -> result = Double.parseDouble(expressionList.get(i - 2)) - Double.parseDouble(expressionList.get(i - 1));
                    case "*" -> result = Double.parseDouble(expressionList.get(i - 2)) * Double.parseDouble(expressionList.get(i - 1));
                    case "/" -> result = Double.parseDouble(expressionList.get(i - 2))/ Double.parseDouble(expressionList.get(i - 1));
                }
                expressionList.set(i - 2, String.valueOf(result));
                expressionList.remove(i);
                expressionList.remove(i - 1);
                i = 0;
            }
        }
        return new DecimalFormat("#.#######################").format(result);
    }
}
