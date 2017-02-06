# RPNCalculator
Functional Programming Assignment 1

This program implements Reverse Polish Notation Calculator which reads the user's input and compute based on RPN's order.

I created a class Calculator which has a compute method gets a stack as a parameter. This compute() calls getInput() which returns a string of the user's input, then parse this string by calling parseExpression() which returns a string without characters other than integers, whitespace(" ") and operators. This will now split the parsed string by whitespaces and store it in an array of strings(splittedStr). 

At this point, it will test whether splittedstr has an element stored(length will be 0, if the user enters only letters or characters which does not belong to the criteria, checked in parseExpression() and it will just terminate the program with a message of "ERROR: Invalid input"). Otherwise, it will go through the for loop and switch cases that checks each element, when it's done it will print out the stack that has the operands left which is not yet calculated and the final answer, by simply calling getStack(). It will call the method itself in a recursive way in order to get a new input from the user without losing the elements in the stack. It also uses the Stack's methods: push(), for putting the operands and final answer in the stack and pop(), for getting the elements from the top of the stack which will be calculated by the operator.

I also added some error checkers/handlers like displaying a string "ERROR: ... ", whenever user tries to enter an invalid input, calculate with only one element in the stack and if the stack is empty.
