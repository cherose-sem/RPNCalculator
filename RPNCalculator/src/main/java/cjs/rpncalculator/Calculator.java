package cjs.rpncalculator;

import java.util.Stack;

/**
 *
 * @author Cherry Rose Semeña
 */
public class Calculator {

    private Stack<Integer> stack;

    public Calculator() {
        this.stack = new Stack<>();
    }

    private String parseExpression(String expr) {
        String parsedExpr = expr.replaceAll("[^\\^\\*\\+\\-\\d/\\s]", "");
        String trimmedExpr = parsedExpr.replaceAll("\\s+", " ");
        return trimmedExpr;
    }

    public void compute(String expr) {

        String parsedStr = parseExpression(expr);
//        System.out.println("PARSED input" + parsedStr);
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
            getStack();
        } else {
            System.out.println("ERROR: Invalid input");
        }
    }

    public void getStack() {
        for (Integer integer : stack) {
            System.out.println(">" + integer);
        }
    }

}
