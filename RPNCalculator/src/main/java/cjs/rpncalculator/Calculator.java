
package cjs.rpncalculator;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 *
 * @author Cherry Rose Semeña
 */
public class Calculator {
    private static String parseExpression(String expr) {
        String parsedExpr = expr.replaceAll("[^\\^\\*\\+\\-\\d/\\s]", "");
        String trimmedExpr = parsedExpr.replaceAll("\\s+", " ");
        return trimmedExpr;
    }

    public static void compute(String expr){
        String validExpr = parseExpression(expr);
        Stack<Integer> stack = new Stack<>();

        try{
        System.out.println(validExpr);
        System.out.println("Input\tOperation\tStack after");
        
        for (String token : validExpr.split("\\s")) {
            System.out.print(token + "\t");

            int secondOperand = 0;
            int firstOperand = 0;

            switch (token) {
                case "+":
                    System.out.print("Operate\t\t");

                    secondOperand = stack.pop();
                    firstOperand = stack.pop();

                    stack.push(firstOperand + secondOperand);
                    break;
                case "-":
                    System.out.print("Operate\t\t");

                    secondOperand = stack.pop();
                    firstOperand = stack.pop();

                    stack.push(firstOperand - secondOperand);
                    break;
                case "*":
                    System.out.print("Operate\t\t");

                    secondOperand = stack.pop();
                    firstOperand = stack.pop();

                    stack.push(firstOperand * secondOperand);
                    break;
                case "/":
                    System.out.print("Operate\t\t");

                    secondOperand = stack.pop();
                    firstOperand = stack.pop();

                    if (secondOperand == 0.0) {
                        throw new ArithmeticException("Cannot divide by zero!");
                    }

                    stack.push(firstOperand / secondOperand);
                    break;
                case "^":
                    System.out.print("Operate\t\t");

                    secondOperand = stack.pop();
                    firstOperand = stack.pop();

                    stack.push((int)Math.pow(firstOperand, secondOperand));
                    break;
                default:
                    System.out.print("Push\t\t");
                    stack.push(Integer.parseInt(token));
                    break;
            }

            System.out.println(stack);
        }
        }catch (ArithmeticException | EmptyStackException err) {
                System.out.println("Invalid input!"+ err.getMessage());
        }
        System.out.println("Final Answer: " + stack.pop());
    }

}
