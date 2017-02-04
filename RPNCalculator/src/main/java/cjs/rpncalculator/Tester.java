package cjs.rpncalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Cherry Rose Semeña
 */
public class Tester {

    public static void main(String[] args) {
        System.out.println("Reverse Polish Notation Calculator:");
        String expr = getInput();
        System.out.println(expr);
        Calculator.compute(expr);
    }

    public static String getInput() {
        String input = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            input = br.readLine();
        } catch (IOException ex) {
            System.out.println("User Input Error:" + ex.getMessage());
        }
        return input;
    }
}
