package com.jit.recursion;

import java.util.Scanner;

public class Display1ToN {

	private Display1ToN() {/*This class is not for instantiation*/
		
	}
	public static void print1(int n) {
		if (n == 0)
			return;
		System.out.println(n + " ");
		print1(n - 1);
	}

	public static void print2(int n) {
		if (n == 0)
			return;
		print2(n - 1);
		System.out.println(n + " ");
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n;
		System.out.println("Enter the value of n");
		n = scan.nextInt();

		print1(n);
		System.out.println();
		print2(n);
		System.out.println();
		scan.close();
	}
}
