package com.jit.recursion;

import java.util.Scanner;

public class Exponential {
	private Exponential() {/* This class is not for instantiation */

	}

	public static float power(float x, int n) {
		if (n == 0)
			return 1;
		return x * power(x, n - 1);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float x;
		int n;
		System.out.println("Enter the value of x and n : ");
		x = scan.nextFloat();
		n = scan.nextInt();
		System.out.println(x + "^" + n + " = " + power(x, n));
		scan.close();
	}
}
