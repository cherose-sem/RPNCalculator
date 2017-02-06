package cjs.rpncalculator;

import java.util.Stack;

/**
 *
 * @author Cherry Rose Semeña
 */
public class Tester {

    public static void main(String[] args) {
        System.out.println("Reverse Polish Notation Calculator:");
        Calculator c  = new Calculator();
        Stack<Integer> stack= new Stack<>();
        c.compute(stack);
    }

    
}
