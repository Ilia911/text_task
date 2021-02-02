package com.epam.jwd.parsing.service.interpreter;

import java.util.Scanner;

public class ExpressionInterpreterClient {

    private Context context = new Context();

    MathExpression minus = () -> {
        int right = context.popValue();
        int left = context.popValue();
        context.pushValue(left - right);
    };

    MathExpression plus = () -> {
        int right = context.popValue();
        int left = context.popValue();
        context.pushValue(left + right);
    };

    MathExpression subtract = () -> {
        int right = context.popValue();
        int left = context.popValue();
        context.pushValue(left / right);
    };

    MathExpression multiply = () -> {
        int right = context.popValue();
        int left = context.popValue();
        context.pushValue(left * right);
    };


    public int parse(String[] tokens) {

        for (String lexeme : tokens) {

            switch (lexeme) {
                case "+":
                    plus.interpret();
                    break;
                case  "-":
                    minus.interpret();
                    break;
                case "/":
                    subtract.interpret();
                    break;
                case "*":
                    multiply.interpret();
                    break;
                default:
                    Scanner scan = new Scanner(lexeme);
                    if (scan.hasNextInt()) {
                        context.pushValue(scan.nextInt());
                    }
            }
        }
        return context.popValue();
    }

}
