package com.epam.jwd.parsing.service.interpreter;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Scanner;

public class Interpreter {
    @FunctionalInterface
    public interface Expr {
        int interpret(String[] context);

        static Expr number(int number) {
            return context -> number;
        }

        static Expr plus(Expr left, Expr right) {
            return context -> left.interpret(context) + right.interpret(context);
        }

        static Expr minus(Expr left, Expr right) {
            return context -> left.interpret(context) - right.interpret(context);
        }

    }

    private static Expr parseToken(String token, ArrayDeque<Expr> stack) {
        Expr left, right;
        switch (token) {
            case "+":
                // It's necessary to remove first the right operand from the stack
                right = stack.pop();
                // ...and then the left one
                left = stack.pop();
                return Expr.plus(left, right);
            case "-":
                right = stack.pop();
                left = stack.pop();
                return Expr.minus(left, right);
            default:
                Scanner scan = new Scanner(token);
                if (scan.hasNextInt()) {
                    return Expr.number(Integer.parseInt(token));
                } else {
                    throw new IllegalArgumentException("Illegal argument!");
                }
        }
    }

    public static Expr parse(String[] expression) {
        ArrayDeque<Expr> stack = new ArrayDeque<>();
        for (String token : expression) {
            stack.push(parseToken(token, stack));
        }
        return stack.pop();
    }
}