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
        String input="";
        Calculator c  = new Calculator();
        do {
            input = getInput();
            c.compute(input);
        } while (!input.equalsIgnoreCase("exit"));
    }

    public static String getInput() {
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
