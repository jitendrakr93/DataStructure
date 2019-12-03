package com.jit.validityofparenthesesexpression;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		String expression;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter an expression with parentheses : ");
		expression = scan.nextLine();
		if (isValid(expression))
			System.out.println("Valid expression");
		else
			System.out.println("Invalid expression");
		scan.close();

	}

	private static boolean isValid(String expr) {
		StackA st = new StackA();
		char ch;
		for (int i = 0; i < expr.length(); i++) {
			if (expr.charAt(i) == '(' || expr.charAt(i) == '{' || expr.charAt(i) == '[')
				st.push(expr.charAt(i));
			if (expr.charAt(i) == ')' || expr.charAt(i) == '}' || expr.charAt(i) == ']')
				if (st.isEmpty()) {
					System.out.println("Right parentheses are more than left parentheses");
					return false;
				} else {
					ch = st.pop();
					if (!matchParentheses(ch, expr.charAt(i))) {
						System.out.println("Ismatched parentheses are : ");
						System.out.println(ch + " and " + expr.charAt(i));
						return false;
					}
				}

		}
		if (st.isEmpty()) {
			System.out.println("Balanced parentheses");
			return true;
		} else {
			System.out.println("left parentheses are more than right parentheses");
			return false;
		}

	}

	private static boolean matchParentheses(char leftPar, char rightPar) {
		if (leftPar == '[' && rightPar == ']')
			return true;
		if (leftPar == '{' && rightPar == '}')
			return true;
		if (leftPar == '(' && rightPar == ')')
			return true;
		return false;
	}

}
