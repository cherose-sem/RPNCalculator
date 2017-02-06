package cjs.rpncalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 *
 * @author Cherry Rose Semeña
 */
public class Calculator {
    
    public Calculator() {
    }

    private String parseExpression(String expr) {
        String parsedExpr = expr.replaceAll("[^\\^\\*\\+\\-\\d/\\s]", "");
        String trimmedExpr = parsedExpr.replaceAll("\\s+", " ");
        return trimmedExpr;
    }

    public Stack<Integer> compute(Stack<Integer> stack) {
        String expr = getInput();
        String parsedStr = parseExpression(expr);
        String[] splittedStr = parsedStr.split("\\s");

        if (splittedStr.length > 0 && !(splittedStr[0].equals(""))) {
            for (String token : splittedStr) {
                int secondOperand = 0;
                int firstOperand = 0;

                switch (token) {
                    case "+":
                        if ((stack.isEmpty())) {
                            System.out.println("ERROR: Empty Stack");
                        }else if(stack.size() == 1){
                            System.out.println("ERROR: Cannot perform operation, only one element left");
                        }else {
                            secondOperand = stack.pop();
                            firstOperand = stack.pop();

                            stack.push(firstOperand + secondOperand);
                        }
                        break;
                    case "-":
                        if ((stack.isEmpty())) {
                            System.out.println("ERROR: Empty Stack");
                        }else if(stack.size() == 1){
                            System.out.println("ERROR: Cannot perform operation, only one element left");
                        } else {
                            secondOperand = stack.pop();
                            firstOperand = stack.pop();

                            stack.push(firstOperand - secondOperand);
                        }
                        break;
                    case "*":
                        if ((stack.isEmpty())) {
                            System.out.println("ERROR: Empty Stack");
                        }else if(stack.size() == 1){
                            System.out.println("ERROR: Cannot perform operation, only one element left");  
                        } else {
                            secondOperand = stack.pop();
                            firstOperand = stack.pop();

                            stack.push(firstOperand * secondOperand);
                        }
                        break;
                    case "/":
                        if ((stack.isEmpty())) {
                            System.out.println("ERROR: Empty Stack");
                        }else if(stack.size() == 1){
                            System.out.println("ERROR: Cannot perform operation, only one element left");   
                        } else {
                            secondOperand = stack.pop();
                            firstOperand = stack.pop();

                            if (secondOperand == 0) {
                                System.out.println("ERROR: Cannot be divided into zero");
                            }else{
                                stack.push(firstOperand / secondOperand);
                            }
                        }
                        break;
                    case "^":
                        if ((stack.isEmpty())) {
                            System.out.println("ERROR: Empty Stack");
                        }else if(stack.size() == 1){
                            System.out.println("ERROR: Cannot perform operation, only one element left");   
                        } else {
                            secondOperand = stack.pop();
                            firstOperand = stack.pop();

                            stack.push((int) Math.pow(firstOperand, secondOperand));
                        }
                        break;
                    default:
                        stack.push(Integer.parseInt(token));
                        break;
                }
            }
            getStack(stack);
            compute(stack);
        } else {
            System.out.println("ERROR: Invalid input");
        }
        return stack;
    }

    public void getStack(Stack<Integer> stack) {
        for (Integer integer : stack) {
            System.out.println(">" + integer);
        }
    }
    
    public String getInput() {
        String input = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            input = br.readLine();
            System.out.println();
        } catch (IOException ex) {
            System.out.println("User Input Error:" + ex.getMessage());
        }
        return input;
    }

}
