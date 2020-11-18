package service;

import java.util.HashMap;
import java.util.Map;

public class Operators {
    static final Map<String, Integer> operators;

    static {
        operators = new HashMap<>();
        operators.put("(", 0);
        operators.put(")", 0);
        operators.put("+", 1);
        operators.put("-", 1);
        operators.put("*", 2);
        operators.put("/", 2);
    }

    public static String getOperatorsToStringWishOutBrackets() {
        StringBuilder operatorsString = new StringBuilder();
        for (String operator : operators.keySet()) {
            if (!operator.equals("(") && !operator.equals(")")) {
                operatorsString.append("\\").append(operator);
            }
        }
        return operatorsString.toString();
    }

    public static String getOperatorsToString() {
        StringBuilder operatorsString = new StringBuilder();
        for (String operator : operators.keySet()) {
            operatorsString.append("\\").append(operator);
        }
        return operatorsString.toString();
    }

    public static String getOperatorsHighPriorityToString() {
        StringBuilder operatorsString = new StringBuilder();
        for (String operator : operators.keySet()) {
            if (operators.get(operator) >= 2)
                operatorsString.append("\\").append(operator);
        }
        return operatorsString.toString();
    }

    public static int getOperatorPriority(String operatorFind) {
        return operators.get(operatorFind);
    }
}
