package service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.regex.Matcher;

import static java.util.regex.Pattern.compile;

public class Parser {
    public static ArrayList<String> parser(String expression) {
        ArrayList<String> output = new ArrayList<>();
        Deque<String> operatorsStack = new ArrayDeque<>();
        Matcher matcher = compile("[" + Operators.getOperatorsToString() + "]|[\\d]+([\\.][\\d+])?").matcher(expression);
        while (matcher.find()) {
            if (matcher.group().matches("[" + Operators.getOperatorsToString() + "]")) {
                switch (matcher.group()) {
                    default -> {
                        if ((!operatorsStack.isEmpty()) &&
                                (Operators.getOperatorPriority(matcher.group()) >= 2)
                                && (Operators.getOperatorPriority(operatorsStack.element()) == Operators.getOperatorPriority(matcher.group()))) {
                            output.add(operatorsStack.poll());
                        }
                        operatorsStack.push(matcher.group());
                    }
                    case "(" -> operatorsStack.push(matcher.group());
                    case ")" -> {
                        while (!operatorsStack.element().equals("(")) {
                            output.add(operatorsStack.poll());
                        }
                        operatorsStack.remove();
                    }
                }
            } else {
                output.add(matcher.group());
            }

        }
        if (matcher.hitEnd()) {
            while (!operatorsStack.isEmpty()) {
                output.add(operatorsStack.poll());
            }
        }
        System.out.println(output.toString());
        return output;
    }

}

