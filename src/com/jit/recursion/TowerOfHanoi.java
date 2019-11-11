package com.jit.recursion;

import java.util.Scanner;

public class TowerOfHanoi {

	private TowerOfHanoi() {/* This class is not for instantiation */

	}

	public static void hanoi(int n,char source,char temp,char dest) {
		if(n == 1) {
			System.out.println("Move disk "+n+" from "+source+" ---> "+dest);
			return;
		}
			hanoi(n-1, source,dest, temp );
			System.out.println("Move disk "+n+" from "+source+" ---> "+dest);
			hanoi(n-1,temp, source, dest);
		
	}
	public static void main(String[] args) {
		int n;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of disks : ");
		n= scan.nextInt();
		hanoi(n, 'A', 'B', 'C');
		scan.close();
	}

}
