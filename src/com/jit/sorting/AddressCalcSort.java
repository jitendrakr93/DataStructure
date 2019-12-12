package com.jit.sorting;

import java.util.Scanner;

public class AddressCalcSort {
	public static void sort(int a[], int n) {
		int i, j, x;
		SortedLinkedList[] List = new SortedLinkedList[6];
		for (i = 0; i < 6; i++)
			List[i] = new SortedLinkedList();
		int large = 0;
		for (i = 0; i < n; i++) {
			x = hash(a[i], large);
			List[x].insertInOrder(a[i]);
		}
		/* Elements of linked list are copied to array */
		Node p;
		i = 0;
		for (j = 0; j <= 5; j++) {
			p = List[j].getStart();/*Implement this getStart method in likned list by own*/
			while (p != null) {
				a[i++] = p.info;
				p = p.link;
			}
		}
	}

	private static int hash(int x, int large) {
		float temp;
		temp=(float)x/large;
		return (int)(temp*5);
	}
	public static void main(String[] args) {

		int i, n;
		int a[] = new int[20];
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of elements : ");
		n = scan.nextInt();

		for (i = 0; i < n; i++) {
			System.out.println("Enter the elements " + (i + 1) + " :");
			a[i] = scan.nextInt();
		}
		sort(a, n);
		System.out.println("Sorted array is : ");
		for (i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		scan.close();
	
	}
}
