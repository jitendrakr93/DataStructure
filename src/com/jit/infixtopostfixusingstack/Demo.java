package com.jit.infixtopostfixusingstack;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		String infix;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter infix expression : ");

		infix = sc.nextLine();
		String postFix = infixToPostfix(infix);
		System.out.println("PostFix expression is : " + postFix);
		System.out.println("Value of expression is : " + evaluatePostFix(postFix));
		sc.close();
	}

	private static String infixToPostfix(String infix) {
		String postFix = new String();
		StackChar st = new StackChar(20);
		char next, symbol;
		for (int i = 0; i < infix.length(); i++) {
			symbol = infix.charAt(i);
			if (symbol == ' ' || symbol == '\t')/* ignore blanks and tabs */
				continue;
			switch (symbol) {
			case '(':
				st.push(symbol);
				break;
			case ')':
				while ((next = st.pop()) != '(')
					postFix = postFix + next;
				break;
			case '+':
			case '-':
			case '*':
			case '/':
			case '%':
			case '^':
				while (!st.isEmpty() && precedence(st.peek()) >= precedence(symbol))
					postFix = postFix + st.pop();
				st.push(symbol);
				break;
			default: /* Operand */
				postFix = postFix + symbol;

			}
		}
		while (!st.isEmpty())
			postFix = postFix + st.pop();
		return postFix;
	}

	private static int precedence(char symbol) {
		switch (symbol) {
		case '(':
			return 0;
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
		case '%':
			return 2;
		case '^':
			return 3;
		default:
			return 0;
		}
	}

	private static int evaluatePostFix(String postFix) {
		StackInt st = new StackInt(20);
		int x, y;
		for (int i = 0; i < postFix.length(); i++) {
			if (Character.isDigit(postFix.charAt(i)))
				st.push(Character.getNumericValue(postFix.charAt(i)));
			else {
				x = st.pop();
				y = st.pop();
				switch (postFix.charAt(i)) {
				case '+':
					st.push(y + x);
					break;
				case '-':
					st.push(y - x);
					break;
				case '*':
					st.push(y * x);
					break;
				case '/':
					st.push(y / x);
					break;
				case '%':
					st.push(y % x);
					break;
				case '^':
					st.push(power(y, x));
				}
			}
		}
		return st.pop();
	}

	private static int power(int b, int a) {
		/*Write your own logic*/
		return 0;
	}

}
