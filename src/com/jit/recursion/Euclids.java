package com.jit.recursion;

import java.util.Scanner;

public class Euclids {

	private Euclids() {/* This class is not for instantiation */

	}

	public static int GCD(int a, int b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}

	public static void main(String[] args) {
		int a, b;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the value of a & b : ");
		a = scan.nextInt();
		b = scan.nextInt();
		System.out.println("GCD of " + a + " and " + b + " is " + GCD(a, b));
		scan.close();
	}

}
