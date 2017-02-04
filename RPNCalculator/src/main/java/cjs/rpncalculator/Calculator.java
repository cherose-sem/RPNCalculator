
package cjs.rpncalculator;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 *
 * @author Cherry Rose Semeña
 */
public class Calculator {
    
    private Stack<Integer> stack;
    
    public Calculator(){
        this.stack = new Stack<>();
    }
    
    public void compute(String expr){
        String validExpr = expr;

        try{
        
        for (String token : validExpr.split("\\s")) {
            int secondOperand = 0;
            int firstOperand = 0;

            switch (token) {
                case "+":
                    secondOperand = stack.pop();
                    firstOperand = stack.pop();

                    stack.push(firstOperand + secondOperand);
                    break;
                case "-":
                    secondOperand = stack.pop();
                    firstOperand = stack.pop();

                    stack.push(firstOperand - secondOperand);
                    break;
                case "*":
                    secondOperand = stack.pop();
                    firstOperand = stack.pop();

                    stack.push(firstOperand * secondOperand);
                    break;
                case "/":
                    secondOperand = stack.pop();
                    firstOperand = stack.pop();

                    if (secondOperand == 0.0) {
                        throw new ArithmeticException("Cannot divide by zero!");
                    }

                    stack.push(firstOperand / secondOperand);
                    break;
                case "^":
                    secondOperand = stack.pop();
                    firstOperand = stack.pop();

                    stack.push((int)Math.pow(firstOperand, secondOperand));
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        }catch (ArithmeticException | EmptyStackException err) {
                System.out.println("Invalid input!"+ err.getMessage());
        }
        getStack();
    }
    
    public void getStack(){
        for (Integer integer : stack) {
            System.out.println(">" + integer);
        }
    }

}
